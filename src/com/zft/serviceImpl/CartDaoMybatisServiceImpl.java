package com.zft.serviceImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.zft.dao.CartDao;
import com.zft.daoImpl.CartDaoMybatisImpl;
import com.zft.entity.Cart;
import com.zft.entity.PageModel;
import com.zft.entity.vo.CartCheckedVo;
import com.zft.service.CartDaoMybatisService;

public class CartDaoMybatisServiceImpl implements CartDaoMybatisService{

	CartDao cartDao = new CartDaoMybatisImpl();
	@Override
	public int addProductToCart(Integer userid, Integer productid, int quantity) {
		
		
		
		//对userid 和 productid 进行非空判断  如果为空则抛出异常
		if(userid!=null&&productid!=null){
			
			//根据userid 和productid 去购物车查询该商品是否已经加入购物车
			Cart cart = cartDao.findCartByUserIdAndProductId(userid, productid);
			if(cart==null){
				
				//如果购物车中不存在该商品  则将该商品添加到购物车
				int count = cartDao.addProductIntoCartByUserIdAndProductId(userid, productid, quantity);
				return count;
			}else{
				
				//如果购物车中存在该商品   则更新该商品在购物车中的数量
				int count = cartDao.updateCartByUserIdAndProductId(userid, productid, quantity);
				return count;
			}
		}else{
			
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public PageModel<Cart> findCartByPage(Integer userid, Integer pageNo, Integer pageSize) {
		return cartDao.findCartByPage(userid, pageNo, pageSize);
	}
	
	/**
	 * 移除购物车中某个商品
	 */
	@Override
	public PageModel<Cart> deleteCartByProductId(Integer userid, Integer productid) {
		 cartDao.deleteCartByProductId(userid, productid);
		 
		 return findCartByPage(userid,1,3);
	}
	
	
	//增加商品数量

	@Override
	public int increaseCartByProductId(Integer userid, Integer productid) {
		return cartDao.increaseCartByProductId(userid, productid);
	}
	
	//减少商品数量
	@Override
	public int reduceCartByProductId(Integer userid, Integer productid) {
		return cartDao.reduceCartByProductId(userid, productid);
	}

	@Override
	public int checkOrUncheckedProduct(Integer userid,int productid,int checked) {
		
		
		
		
		
		return cartDao.checkOrUncheckedProduct(userid, productid, checked);
	/*	CartCheckedVo cartCheckedVo = new CartCheckedVo();
		
		String _product_id = request.getParameter("product_id");
		//product_id 是比传递的数据
		Integer product_id = null;
		if(_product_id !=null && !(_product_id.equals(""))){
			try{
				product_id = Integer.parseInt(_product_id);
			}catch(NumberFormatException e){
				cartCheckedVo.setErrno(CartCheckedVo.ERRNO_FAIL);
				e.printStackTrace();
				try {
					throw new Exception("全选、取消全选传递product_id错误");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
		//checked
		String _checked = request.getParameter("checked");
		Integer checked = null;
		if(_checked !=null && !(_checked.equals(""))){
			try{
				
				checked = Integer.parseInt(_checked);
			}catch(NumberFormatException e){
				cartCheckedVo.setErrno(CartCheckedVo.ERRNO_FAIL);
				e.printStackTrace();
				try {
					throw new Exception("全选、取消全选传递checked错误");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
		
		int count = cartDao.checkOrUncheckedProduct(userid, product_id, checked);
		if(count>0){
			//succ  将product_id 和 checked封装到CartCheckedVO
			cartCheckedVo.setErrno(CartCheckedVo.ERRNO_SUCC);
			cartCheckedVo.setProduct_id(product_id);
			cartCheckedVo.setChecked(checked);
		}else{
			
			//fail
		}
		return cartCheckedVo;*/
	}

	@Override
	public int findAllProductNumber(Integer userid) {
		
		return cartDao.findAllProductNumber(userid);
	}
	
	
	
}
