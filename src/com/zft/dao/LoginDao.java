package com.zft.dao;

import com.zft.entity.User;

public interface LoginDao {
	
	public int checkUserName(String username);
	
	
	public User findUserByUsernameAndPassword(String username,String password);
	
	
	
	
	/**
	 * update user token
	 */
	
	public int updateTokenByUserId(Integer userid,String token);
	
	
	/**
	 * �����û�token��ѯ�û���Ϣ
	 */
	
	public User findUserByToken(String token);
}
