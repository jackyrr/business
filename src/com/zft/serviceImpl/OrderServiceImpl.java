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
		
		//1.��ȡ��ַ
		String shipping_id = request.getParameter("shipping_id");
		if(shipping_id==null || shipping_id.equals("")){
			try {
				throw new Exception("���͵�ַ����д������");
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
				throw new Exception("��ַID���ݲ���ȷ��");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		//��ѯ�û��µ�����Ʒ
		List<Cart> carts = cartDao.findCartListByUserId(userid);
		
		//��ȡ������ϸ
		List<UserOrderItems> items = convertCartToUserOrderItems(userid, carts);
		
		//���㶩���ܼ۸�
		BigDecimal totalPriceDecimal = getTotalPrice(items);
		
		//��������
		UserOrder order = createOrder(userid, _shipping_id, totalPriceDecimal);
		
		if(order!=null){
			//��������ϸ���뵽���ݿ�
			addOrderItemToDB(order, items);
		}
		
		//���ٿ��
		
		for(UserOrderItems item : items){
			productDao.reduceProductStock(item.getProduct_id(), item.getQuantity());
		}
		//��չ��ﳵ
		cartDao.deleteCheckedProductByUserId(userid);
		
		return order;
	}
	
	/**
	 * �����ﳵת��UserOrderItems
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
				//������Ʒ�ܵļ۸�
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
	 * ��������
	 */
	private UserOrder createOrder(Integer user_id,Integer shipping_id,BigDecimal payment){
		UserOrder order = new UserOrder();
		order.setOrder_no(generateOrderNo());
		order.setUser_id(user_id);
		order.setShipping_id(shipping_id);
		//�����ܽ��
		order.setPayment(payment);
		order.setPayment_type(1);
		order.setPostage(10);
		//���ö���״̬
		order.setStatus(OrderStatusEnum.UNPLAY.getStatus());
		
		//���������뵽���ݿ�
		int result = orderDao.addUserOrder(order);
		if(result>0){
			//succ
			
			return order;
			
		}else{
			//false
			try {
				throw new Exception("���붩��ʧ�ܣ�����");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return order;
	}
	
	/**
	 * ���ɶ������
	 */
	private long generateOrderNo(){
		return System.currentTimeMillis()+(int)(Math.random()*100);
	}
	
	
	/**
	 * ����۸�
	 */
	private BigDecimal getTotalPrice(List<UserOrderItems> userOrderitems){
		
		BigDecimal bigDecimal = new BigDecimal("0");
		for(UserOrderItems orderItem : userOrderitems){
			bigDecimal = bigDecimal.add(orderItem.getTotal_price());
		}
		return bigDecimal;
	}
	
	/**
	 * ��������ϸ���뵽���ݿ�
	 */
	private int addOrderItemToDB(UserOrder order,List<UserOrderItems> orderItems){
		
		
		//Ϊÿ��������ϸ��Ӷ�����
		for(UserOrderItems orderItem : orderItems){
			orderItem.setOrder_no(order.getOrder_no());
			//�ж���Ʒ����Ƿ����
			long stock = productDao.getProductStock(orderItem.getProduct_id());
			if(stock < orderItem.getQuantity()){
				//��治��
				try {
					throw new Exception("��治�㣡");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			//��������ϸ���뵽���ݿ�
		}
		return userOrderItemsDao.addBatch(orderItems);
//		return 0;
	}

	
	/**
	 * ��ҳ
	 */
	@Override
	public PageModel<OrderVo> findUserOrderByPage(Integer userid, HttpServletRequest request) {
		String pageNo = request.getParameter("pageNo");
		String pageSize = request.getParameter("pageSize");
		
		Integer _pageNo = 0;
		Integer _pageSize = 0;
		
		if(pageNo == null || pageSize == null){
			try {
				throw new Exception("���봫�ݲ��� ");
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
				throw new Exception("pageSize/pageNo����");
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
	 * ��ѯ�ö����µĶ�������
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
	 * �޸Ķ���״̬
	 */
	@Override
	public int updateOrderStatusByOrderNo(long order_no, Integer status) {
		
		return orderDao.updateOrderStatusByOrderNo(order_no, status);
	} 
	
	
	
}

