package com.zft.test;

import java.util.List;

import org.junit.Test;

import com.zft.dao.UserDao;
import com.zft.daoImpl.UserDaoImpl;
import com.zft.entity.User;

public class TestUser {

	
	public void testfindAllUser(){
		
		UserDao userDao = new UserDaoImpl();
		List<User> list = userDao.findAllUser();
		
		for (User user : list) {
			System.out.println(user);
		}
	}
	
	
	@Test
	public void testfindOneUser(){
		
		UserDao userDao = new UserDaoImpl();
		System.out.println(userDao.findOneUser(2));
		
		
	}
	
	
}
