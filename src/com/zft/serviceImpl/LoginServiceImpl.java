package com.zft.serviceImpl;

import com.zft.dao.LoginDao;
import com.zft.daoImpl.LoginImpl;
import com.zft.entity.User;
import com.zft.service.ILoginService;

public class LoginServiceImpl implements ILoginService {

	LoginDao loginDao = new LoginImpl();
	
	@Override
	public User login(String username, String password) {
		
		//service²ãÈ¥µ÷ÓÃDAO²ã
		
		return loginDao.findUserByUsernameAndPassword(username, password);
		
		
		
	}

	@Override
	public int updateTokenByUserId(Integer userid, String token) {

		return loginDao.updateTokenByUserId(userid, token);
	}

	@Override
	public User findUserByToken(String token) {
		return loginDao.findUserByToken(token);
	}

}
