package com.zft.test;

import java.util.List;

import org.junit.Test;

import com.zft.dao.UserOrderDao;
import com.zft.daoImpl.UserOrderDaoImpl;
import com.zft.entity.UserOrderItems;

public class TestOrder {

	
	public void testfinAllOrderByPage(){
		
		
		UserOrderDao userOrderDao = new UserOrderDaoImpl();
		System.out.println(userOrderDao.findUserOrderByPage(2, 1, 2));
		
	}
	
	public void testfindAllUserOrderItems(){
		UserOrderDao userOrderDao = new UserOrderDaoImpl();
		List<UserOrderItems> list = userOrderDao.findAllUserOrderItems(1521764904694L);
		System.out.println(list.size());
		
	}
	
	public void testfindUserOrderDetailByOrderNo(){
		UserOrderDao userOrderDao = new UserOrderDaoImpl();
		System.out.println(userOrderDao.findUserOrderDetailByOrderNo(1521764904694L));
		
		
	}
	
	@Test
	public void testupdateOrderStatusByOrderNo(){
		UserOrderDao userOrderDao = new UserOrderDaoImpl();
		userOrderDao.updateOrderStatusByOrderNo(1521764904694L, 0);
	}
	
	
}
