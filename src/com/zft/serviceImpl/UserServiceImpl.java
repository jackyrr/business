package com.zft.serviceImpl;

import java.util.List;

import com.zft.dao.UserDao;
import com.zft.daoImpl.UserDaoImpl;
import com.zft.entity.User;
import com.zft.service.UserService;

public class UserServiceImpl implements UserService{

	@Override
	public List<User> findAllUser() {
		UserDao userDao = new UserDaoImpl();
		return userDao.findAllUser();
	}
	
}
