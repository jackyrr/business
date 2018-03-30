package com.zft.serviceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.zft.commom.OrderStatusEnum;
import com.zft.dao.CartDao;
import com.zft.dao.ProductDao;
import com.zft.dao.UserOrderDao;
import com.zft.dao.UserOrderItemsDao;
import com.zft.daoImpl.CartDaoMybatisImpl;
import com.zft.daoImpl.ProductDaoImpl;
import com.zft.daoImpl.UserOrderDaoImpl;
import com.zft.daoImpl.UserOrderItemsDaoImpl;
import com.zft.entity.Cart;
import com.zft.entity.PageModel;
import com.zft.entity.Product;
import com.zft.entity.UserOrder;
import com.zft.entity.UserOrderItems;
import com.zft.entity.vo.OrderItemVo;
import com.zft.entity.vo.OrderVo;
import com.zft.service.OrderService;

public class OrderServiceImpl implements OrderService{

	private CartDao cartDao = new CartDaoMybatisImpl(); 
	
	private UserOrderDao orderDao = new UserOrderDaoImpl();
	
	private UserOrderItemsDao userOrderItemsDao = new UserOrderItemsDaoImpl(); 
	
	private ProductDao productDao = new ProductDaoImpl();
	
	@Override
	public UserOrder createOrder(Integer userid,HttpServletRequest request) {
		
		//1.获取地址
		String shipping_id = request.getParameter("shipping_id");
		if(shipping_id==null || shipping_id.equals("")){
			try {
				throw new Exception("配送地址必须写！！！");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		Integer _shipping_id = null;
		try{
			
			_shipping_id = Integer.valueOf(shipping_id);
		}catch(Exception e){
			e.printStackTrace();
			try {
				throw new Exception("地址ID传递不正确！");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		//查询用户下单的商品
		List<Cart> carts = cartDao.findCartListByUserId(userid);
		
		//获取订单明细
		List<UserOrderItems> items = convertCartToUserOrderItems(userid, carts);
		
		//计算订单总价格
		BigDecimal totalPriceDecimal = getTotalPrice(items);
		
		//创建订单
		UserOrder order = createOrder(userid, _shipping_id, totalPriceDecimal);
		
		if(order!=null){
			//将订单明细插入到数据库
			addOrderItemToDB(order, items);
		}
		
		//减少库存
		
		for(UserOrderItems item : items){
			productDao.reduceProductStock(item.getProduct_id(), item.getQuantity());
		}
		//清空购物车
		cartDao.deleteCheckedProductByUserId(userid);
		
		return order;
	}
	
	/**
	 * 将购物车转成UserOrderItems
	 * @param userid
	 * @param carts
	 * @return
	 */
	private List<UserOrderItems> convertCartToUserOrderItems(Integer userid,List<Cart> carts){
		
		List<UserOrderItems> list = new ArrayList<UserOrderItems>();
		for(Cart cart : carts){
			UserOrderItems orderItem = new UserOrderItems();
			Product product = cart.getProduct();
			if(product!=null){
				orderItem.setProduct_id(product.getId());
				orderItem.setProduct_name(product.getName());
				orderItem.setProduct_image(product.getMain_image());
				orderItem.setCurrent_unit_price(product.getPrice());
				//计算商品总的价格
				orderItem.setQuantity(cart.getQuantity());
				double _total_price = (product.getPrice().doubleValue())*cart.getQuantity();
				orderItem.setTotal_price(new BigDecimal(_total_price));
				
				orderItem.setUser_id(userid);
				list.add(orderItem);
			}
		}
		return list;
	}
	
	/**
	 * 创建订单
	 */
	private UserOrder createOrder(Integer user_id,Integer shipping_id,BigDecimal payment){
		UserOrder order = new UserOrder();
		order.setOrder_no(generateOrderNo());
		order.setUser_id(user_id);
		order.setShipping_id(shipping_id);
		//订单总金额
		order.setPayment(payment);
		order.setPayment_type(1);
		order.setPostage(10);
		//设置订单状态
		order.setStatus(OrderStatusEnum.UNPLAY.getStatus());
		
		//将订单插入到数据库
		int result = orderDao.addUserOrder(order);
		if(result>0){
			//succ
			
			return order;
			
		}else{
			//false
			try {
				throw new Exception("插入订单失败！！！");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return order;
	}
	
	/**
	 * 生成订单编号
	 */
	private long generateOrderNo(){
		return System.currentTimeMillis()+(int)(Math.random()*100);
	}
	
	
	/**
	 * 计算价格
	 */
	private BigDecimal getTotalPrice(List<UserOrderItems> userOrderitems){
		
		BigDecimal bigDecimal = new BigDecimal("0");
		for(UserOrderItems orderItem : userOrderitems){
			bigDecimal = bigDecimal.add(orderItem.getTotal_price());
		}
		return bigDecimal;
	}
	
	/**
	 * 将订单明细插入到数据库
	 */
	private int addOrderItemToDB(UserOrder order,List<UserOrderItems> orderItems){
		
		
		//为每个订单明细添加订单号
		for(UserOrderItems orderItem : orderItems){
			orderItem.setOrder_no(order.getOrder_no());
			//判断商品库存是否充足
			long stock = productDao.getProductStock(orderItem.getProduct_id());
			if(stock < orderItem.getQuantity()){
				//库存不足
				try {
					throw new Exception("库存不足！");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			//将订单明细插入到数据库
		}
		return userOrderItemsDao.addBatch(orderItems);
//		return 0;
	}

	
	/**
	 * 分页
	 */
	@Override
	public PageModel<OrderVo> findUserOrderByPage(Integer userid, HttpServletRequest request) {
		String pageNo = request.getParameter("pageNo");
		String pageSize = request.getParameter("pageSize");
		
		Integer _pageNo = 0;
		Integer _pageSize = 0;
		
		if(pageNo == null || pageSize == null){
			try {
				throw new Exception("必须传递参数 ");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		try{
			_pageNo = Integer.parseInt(pageNo);
			_pageSize = Integer.parseInt(pageSize);
		}catch(Exception e){
			e.printStackTrace();
			try {
				throw new Exception("pageSize/pageNo有误");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		
		
		PageModel<UserOrder> pageModel = orderDao.findUserOrderByPage(userid, _pageNo, _pageSize);
		
		 return convertUserOrderToOrderVo(pageModel);
		
	}
	
	
	/**
	 * UserOrder----->OrderVo
	 */
	private PageModel<OrderVo>  convertUserOrderToOrderVo(PageModel<UserOrder> pageModel){
		PageModel<OrderVo> _pageModel = new PageModel<>();
		if(pageModel != null){
			
			List<OrderVo> list = new ArrayList<>(); 
			List<UserOrder> orders = pageModel.getData();
			for(UserOrder order : orders){
				OrderVo orderVo = new OrderVo();
				orderVo.convertUserOrderToOrderVo(order);
				list.add(orderVo);
			}
			_pageModel.setData(list);
			_pageModel.setTotalPage(pageModel.getTotalPage());
		}
		return _pageModel;
	}
	
	
	/**
	 * 查询该订单下的订单详情
	 */
	@Override
	public List<OrderItemVo> findAllUserOrderItems(long order_no) {
		
		List<UserOrderItems> items = orderDao.findAllUserOrderItems(order_no);
		
		List<OrderItemVo> list = new ArrayList<>();
		for (UserOrderItems item : items) {
			OrderItemVo vo = new OrderItemVo();
			vo.convertOrderItemsToOrderItemVo(item);
			list.add(vo);
		}
		return list;
	}

	@Override
	public UserOrder findUserOrderDetailByOrderNo(long order_no) {
		
		return orderDao.findUserOrderDetailByOrderNo(order_no);
	}
	
	/**
	 * 修改订单状态
	 */
	@Override
	public int updateOrderStatusByOrderNo(long order_no, Integer status) {
		
		return orderDao.updateOrderStatusByOrderNo(order_no, status);
	} 
	
	
	
}

