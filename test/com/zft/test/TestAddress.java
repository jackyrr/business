package com.zft.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

import org.junit.Test;

import com.zft.dao.UserAddressDao;
import com.zft.daoImpl.AddressDaoMybatisImpl;
import com.zft.entity.Address;

public class TestAddress {
	
	
	public void testaddAddress(){
		String str = "2018-03-02";
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date create_time = df.parse(str);
			Date update_time = df.parse(str);
			UserAddressDao userAddressDao = new AddressDaoMybatisImpl();
			Address address = new Address(5,2, "kkkkk", "1785", "58907", "111省", "吃吃吃", "小店区", "山西大学", "03100", create_time, update_time);
			int count = userAddressDao.addAddress(2, address);
			System.out.println(address.getId());
		} catch (Exception e) {
			
		}
		
	}
	
	
	public void testdeleteAddressByUserid(){
		
		UserAddressDao userAddressDao = new AddressDaoMybatisImpl();
		userAddressDao.deleteAddressByUserid(2, 11);
		
	}
	

	public void testfindAllCount(){
		UserAddressDao userAddressDao = new AddressDaoMybatisImpl();
		System.out.println(userAddressDao.findAllCount());
		
	}
	
	
	public void testfindUserAddress(){
		
		UserAddressDao userAddressDao = new AddressDaoMybatisImpl();
		userAddressDao.findUserAddress(1, 5, 2);
		System.out.println(userAddressDao.findUserAddress(1, 5, 2).getData().size());
	}
	
	/**
	 * find one address
	 */
	@Test
	public void testfindOneAddress(){
		
		UserAddressDao userAddressDao = new AddressDaoMybatisImpl();
		userAddressDao.findOneAddress(2, 13);
	}
	
	
	public void testupdateUserAddressByUserid(){
		
		UserAddressDao userAddressDao = new AddressDaoMybatisImpl();
		
		
	}
	
	
	
}
