package com.zft.test;

import java.util.List;

import org.junit.Test;

import com.zft.dao.CartDao;
import com.zft.daoImpl.CartDaoMybatisImpl;
import com.zft.entity.Cart;
import com.zft.service.CartDaoMybatisService;
import com.zft.serviceImpl.CartDaoMybatisServiceImpl;

public class TestCart {
	
	/**
	 * 测试       根据userID跟productID查询购物车信息
	 */
	public void testfindCartByUserIdAndProductId(){
		
		CartDao cartDao = new CartDaoMybatisImpl();
		Cart cart = cartDao.findCartByUserIdAndProductId(2, 4);
		System.out.println(cart);
	}
	
	/**
	 * 测试     更新购物车中商品的数量
	 */
	public void testupdateCartByUserIdAndProductId(){
		CartDao cartDao = new CartDaoMybatisImpl();
		int count = cartDao.updateCartByUserIdAndProductId(2, 4, 11);
		System.out.println(count);
	}
	
	/**
	 * 测试       用户将商品添加到购物车
	 * @param args
	 */
	
	@Test
	public void testaddProductIntoCartByUserIdAndProductId(){
		
		CartDao cartDao = new CartDaoMybatisImpl();
		cartDao.addProductIntoCartByUserIdAndProductId(2, 4, 9);
	}
	
	/**
	 * 
	 * @param args
	 */
	public void testaddProductIntoCart(){
		CartDaoMybatisService cartDaoMybatisService = new CartDaoMybatisServiceImpl();
		int count = cartDaoMybatisService.addProductToCart(6, 6, 77);
		System.out.println(count);
	}
	
	
	public void testdeleteCartByProductId(){
		
		CartDao cartDao = new CartDaoMybatisImpl();
		cartDao.deleteCartByProductId(2, 6);
		
	}
	

	public void testdeleteCheckedProduct(){
		CartDao cartDao = new CartDaoMybatisImpl();
		cartDao.deleteCheckedProductByUserId(2);
		
		
	}
	
	
	
	public void  testfindCartListByUserId(){
		CartDao cartDao = new CartDaoMybatisImpl();
		List<Cart> list = cartDao.findCartListByUserId(2);
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		
	}
	
	public void testfindCartNumber(){
		CartDao cartDao = new CartDaoMybatisImpl();
		cartDao.findCartNumber();
	}
	
	
	public void testfindCartByPage(){
		CartDao cartDao = new CartDaoMybatisImpl();
		System.out.println(cartDao.findCartByPage(2, 1, 5));
	}
	

	
	/**
	 * 所有商品数量
	 */
	@Test
	public void testfindAllProductNumber(){
		CartDao cartDao = new CartDaoMybatisImpl();
		System.out.println(cartDao.findAllProductNumber(2));
	}
	

	public void testincreseCart(){
		CartDao cartDao = new CartDaoMybatisImpl();
		//cartDao.increaseCartByProductId(2, 2);
		cartDao.reduceCartByProductId(2, 2);
	}
	

	public void testcheckedOrunchecked(){
		
		
		CartDao cartDao = new CartDaoMybatisImpl();
		cartDao.checkOrUncheckedProduct(2, 5, 0);
		
	}
}
