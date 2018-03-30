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
	 * 根据用户token查询用户信息
	 */
	
	public User findUserByToken(String token);
}
