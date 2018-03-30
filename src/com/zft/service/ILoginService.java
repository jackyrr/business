package com.zft.service;

import com.zft.entity.User;

public interface ILoginService {
	
	
	public User login(String username,String password); 
	
	
	public int updateTokenByUserId(Integer userid,String token);
	
	
	/**
	 * ����token��ѯ�û���Ϣ
	 */
	
	public User findUserByToken(String token);
	
}
