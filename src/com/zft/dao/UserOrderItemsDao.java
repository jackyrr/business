package com.zft.dao;

import java.util.List;

import com.zft.entity.UserOrderItems;

/**
 * 订单明细
 * @author Administrator
 *
 */
public interface UserOrderItemsDao {
	
	/**
	 * 批量添加订单明细
	 */
	public int addBatch(List<UserOrderItems> orderItems);
		
	
	
	
	/**
	 * 获取订单的商品信息
	 */
	
	public List<UserOrderItems> findOrderItemByOrderNo(Integer order_no);
	
	
	
	
}
