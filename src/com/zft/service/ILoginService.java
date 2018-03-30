package com.zft.service;

import com.zft.entity.User;

public interface ILoginService {
	
	
	public User login(String username,String password); 
	
	
	public int updateTokenByUserId(Integer userid,String token);
	
	
	/**
	 * 根据token查询用户信息
	 */
	
	public User findUserByToken(String token);
	
}
