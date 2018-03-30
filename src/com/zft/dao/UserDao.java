package com.zft.dao;

import java.util.List;

import com.zft.entity.User;

/**
 * 用户接口
 * @author Administrator
 *
 */

public interface UserDao {
	
	
	/**
	 * 查询所有用户
	 * @return
	 */
	public List<User> findAllUser();
	
	
	/**
	 * 根据userID查询用户
	 */
	
	public User findOneUser(Integer user_id);
}
