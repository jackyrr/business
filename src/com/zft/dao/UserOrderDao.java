package com.zft.dao;

import java.util.List;

import com.zft.entity.PageModel;
import com.zft.entity.UserOrder;
import com.zft.entity.UserOrderItems;

public interface UserOrderDao {
	
	/**
	 * ��������
	 * add userOrder
	 * @param userOrder
	 * @return
	 */
	public int addUserOrder(UserOrder userOrder);
	
	
	
	
	/**
	 * ��ȡ�����б�
	 */
	
	
	public PageModel<UserOrder> findUserOrderByPage(Integer userid,Integer pageNo,Integer pageSize);
	
	
	
	
	/**
	 * �������Ų�ѯ
	 * 
	 */
	
	
	public  UserOrder findUserOrderDetailByOrderNo(long order_no);
	
	
	
	
	
	/**
	 * ͨ�������Ż�ȡ��������
	 */
	
	public List<UserOrderItems> findAllUserOrderItems(long order_no);
	
	
	/**
	 * ���Ķ���״̬
	 */
	
	
	public int updateOrderStatusByOrderNo(long order_no,Integer status); 
	
	
	
	
	
}
