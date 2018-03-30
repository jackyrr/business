package com.zft.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.zft.entity.PageModel;
import com.zft.entity.UserOrder;
import com.zft.entity.vo.OrderItemVo;
import com.zft.entity.vo.OrderVo;

public interface OrderService {

	/**
	 * 用户下单
	 * @param userid
	 * @param HttpServletRequest request  配送地址
	 * @return
	 */
	public UserOrder createOrder(Integer userid,HttpServletRequest request);
	
	
	
	/**
	 * 分页查询订单
	 */
	
	
	public PageModel<OrderVo> findUserOrderByPage(Integer userid,HttpServletRequest request);
	
	
	
	/**
	 * 根据订单号查询该订单下的订单详情
	 */
	
	public List<OrderItemVo> findAllUserOrderItems(long order_no);
	
	
	/**
	 * 根据订单号查询某一个订单号
	 * @param order_no
	 * @return
	 */
	public  UserOrder findUserOrderDetailByOrderNo(long order_no);
	
	
	/**
	 * 修改订单状态
	 * @param order_no 订单号
	 * @param status 
	 * @return
	 */
	public int updateOrderStatusByOrderNo(long order_no,Integer status);
}
