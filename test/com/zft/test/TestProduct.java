package com.zft.test;

import org.junit.Test;

import com.zft.dao.ProductDao;
import com.zft.daoImpl.ProductDaoImpl;

public class TestProduct {
	
	
	public void testgetProductStock(){
		
		ProductDao productDao = new ProductDaoImpl();
		System.out.println(productDao.getProductStock(2));
	}
	
	@Test
	public void testreduceProductStock(){
		
		ProductDao productDao = new ProductDaoImpl();
		productDao.reduceProductStock(6, 4);

		
	}
}
