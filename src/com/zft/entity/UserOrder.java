package com.zft.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class UserOrder implements Serializable{
	
	
	private Integer oid; //订单ID	   
	private long order_no;   	//订单号
	private Integer user_id; 	//用户ID
	private Integer shipping_id;	//地址ID
	private BigDecimal payment;		//实际付款金额,单位元
	private Integer payment_type; //支付类型 1-在线支付 2-货到付款
	private Integer postage;		//运费,单位元
	private Integer status;		//订单状态
	private Date payment_time;	//支付时间
	private Date send_time;		//发货时间
	private Date end_time;		//交易完成时间
	private Date close_time;		//交易关闭时间
	private Date create_time;		//创建时间
	private Date update_time;		//更新时间
	
	public UserOrder(){
		
	}

	public UserOrder(Integer oid, long order_no, Integer user_id, Integer shipping_id, BigDecimal payment,
			Integer payment_type, Integer postage, Integer status, Date payment_time, Date send_time, Date end_time,
			Date close_time, Date create_time, Date update_time) {
		super();
		this.oid = oid;
		this.order_no = order_no;
		this.user_id = user_id;
		this.shipping_id = shipping_id;
		this.payment = payment;
		this.payment_type = payment_type;
		this.postage = postage;
		this.status = status;
		this.payment_time = payment_time;
		this.send_time = send_time;
		this.end_time = end_time;
		this.close_time = close_time;
		this.create_time = create_time;
		this.update_time = update_time;
	}

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public long getOrder_no() {
		return order_no;
	}

	public void setOrder_no(long order_no) {
		this.order_no = order_no;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getShipping_id() {
		return shipping_id;
	}

	public void setShipping_id(Integer shipping_id) {
		this.shipping_id = shipping_id;
	}

	public BigDecimal getPayment() {
		return payment;
	}

	public void setPayment(BigDecimal payment) {
		this.payment = payment;
	}

	public Integer getPayment_type() {
		return payment_type;
	}

	public void setPayment_type(Integer payment_type) {
		this.payment_type = payment_type;
	}

	public Integer getPostage() {
		return postage;
	}

	public void setPostage(Integer postage) {
		this.postage = postage;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getPayment_time() {
		return payment_time;
	}

	public void setPayment_time(Date payment_time) {
		this.payment_time = payment_time;
	}

	public Date getSend_time() {
		return send_time;
	}

	public void setSend_time(Date send_time) {
		this.send_time = send_time;
	}

	public Date getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}

	public Date getClose_time() {
		return close_time;
	}

	public void setClose_time(Date close_time) {
		this.close_time = close_time;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	@Override
	public String toString() {
		return "UserOrder [oid=" + oid + ", order_no=" + order_no + ", user_id=" + user_id + ", shipping_id="
				+ shipping_id + ", payment=" + payment + ", payment_type=" + payment_type + ", postage=" + postage
				+ ", status=" + status + ", payment_time=" + payment_time + ", send_time=" + send_time + ", end_time="
				+ end_time + ", close_time=" + close_time + ", create_time=" + create_time + ", update_time="
				+ update_time + "]";
	}


}
