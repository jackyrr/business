package com.zft.dao;

import java.util.List;

import com.zft.entity.UserOrderItems;

/**
 * ������ϸ
 * @author Administrator
 *
 */
public interface UserOrderItemsDao {
	
	/**
	 * ������Ӷ�����ϸ
	 */
	public int addBatch(List<UserOrderItems> orderItems);
		
	
	
	
	/**
	 * ��ȡ��������Ʒ��Ϣ
	 */
	
	public List<UserOrderItems> findOrderItemByOrderNo(Integer order_no);
	
	
	
	
}
