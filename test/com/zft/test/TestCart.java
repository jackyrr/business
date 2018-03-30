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
	 * ����       ����userID��productID��ѯ���ﳵ��Ϣ
	 */
	public void testfindCartByUserIdAndProductId(){
		
		CartDao cartDao = new CartDaoMybatisImpl();
		Cart cart = cartDao.findCartByUserIdAndProductId(2, 4);
		System.out.println(cart);
	}
	
	/**
	 * ����     ���¹��ﳵ����Ʒ������
	 */
	public void testupdateCartByUserIdAndProductId(){
		CartDao cartDao = new CartDaoMybatisImpl();
		int count = cartDao.updateCartByUserIdAndProductId(2, 4, 11);
		System.out.println(count);
	}
	
	/**
	 * ����       �û�����Ʒ��ӵ����ﳵ
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
	 * ������Ʒ����
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
