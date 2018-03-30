package com.zft.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.zft.entity.PageModel;
import com.zft.entity.UserOrder;
import com.zft.entity.vo.OrderItemVo;
import com.zft.entity.vo.OrderVo;

public interface OrderService {

	/**
	 * �û��µ�
	 * @param userid
	 * @param HttpServletRequest request  ���͵�ַ
	 * @return
	 */
	public UserOrder createOrder(Integer userid,HttpServletRequest request);
	
	
	
	/**
	 * ��ҳ��ѯ����
	 */
	
	
	public PageModel<OrderVo> findUserOrderByPage(Integer userid,HttpServletRequest request);
	
	
	
	/**
	 * ���ݶ����Ų�ѯ�ö����µĶ�������
	 */
	
	public List<OrderItemVo> findAllUserOrderItems(long order_no);
	
	
	/**
	 * ���ݶ����Ų�ѯĳһ��������
	 * @param order_no
	 * @return
	 */
	public  UserOrder findUserOrderDetailByOrderNo(long order_no);
	
	
	/**
	 * �޸Ķ���״̬
	 * @param order_no ������
	 * @param status 
	 * @return
	 */
	public int updateOrderStatusByOrderNo(long order_no,Integer status);
}
