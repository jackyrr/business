package com.zft.dao;

import java.util.List;

import com.zft.entity.PageModel;
import com.zft.entity.UserOrder;
import com.zft.entity.UserOrderItems;

public interface UserOrderDao {
	
	/**
	 * 创建订单
	 * add userOrder
	 * @param userOrder
	 * @return
	 */
	public int addUserOrder(UserOrder userOrder);
	
	
	
	
	/**
	 * 获取订单列表
	 */
	
	
	public PageModel<UserOrder> findUserOrderByPage(Integer userid,Integer pageNo,Integer pageSize);
	
	
	
	
	/**
	 * 按订单号查询
	 * 
	 */
	
	
	public  UserOrder findUserOrderDetailByOrderNo(long order_no);
	
	
	
	
	
	/**
	 * 通过订单号获取订单详情
	 */
	
	public List<UserOrderItems> findAllUserOrderItems(long order_no);
	
	
	/**
	 * 更改订单状态
	 */
	
	
	public int updateOrderStatusByOrderNo(long order_no,Integer status); 
	
	
	
	
	
}
