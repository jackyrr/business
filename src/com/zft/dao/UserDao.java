package com.zft.dao;

import java.util.List;

import com.zft.entity.User;

/**
 * �û��ӿ�
 * @author Administrator
 *
 */

public interface UserDao {
	
	
	/**
	 * ��ѯ�����û�
	 * @return
	 */
	public List<User> findAllUser();
	
	
	/**
	 * ����userID��ѯ�û�
	 */
	
	public User findOneUser(Integer user_id);
}
