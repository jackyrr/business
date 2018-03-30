package com.zft.entity.vo;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.zft.commom.OrderStatusEnum;
import com.zft.constants.PaymentTypeEnum;
import com.zft.entity.UserOrder;

public class OrderVo {
	
	private Integer oid; //����ID	   
	private long order_no;   	//������
	private Integer user_id; 	//�û�ID
	private Integer shipping_id;	//��ַID
	private String payment;		//ʵ�ʸ�����,��λԪ
	private String payment_type; //֧������ 1-����֧�� 2-��������
	private Integer postage;		//�˷�,��λԪ
	private String status;		//����״̬
	private String payment_time;	//֧��ʱ��
	private String send_time;		//����ʱ��
	private String end_time;		//�������ʱ��
	private String close_time;		//���׹ر�ʱ��
	private String create_time;		//����ʱ��
	private String update_time;		//����ʱ��
	
	
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


	public String getPayment() {
		return payment;
	}


	public void setPayment(String payment) {
		this.payment = payment;
	}


	public String getPayment_type() {
		return payment_type;
	}


	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}


	public Integer getPostage() {
		return postage;
	}


	public void setPostage(Integer postage) {
		this.postage = postage;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	


	public String getPayment_time() {
		return payment_time;
	}


	public void setPayment_time(String payment_time) {
		this.payment_time = payment_time;
	}


	public String getSend_time() {
		return send_time;
	}


	public void setSend_time(String send_time) {
		this.send_time = send_time;
	}


	public String getEnd_time() {
		return end_time;
	}


	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}


	public String getClose_time() {
		return close_time;
	}


	public void setClose_time(String close_time) {
		this.close_time = close_time;
	}


	public String getCreate_time() {
		return create_time;
	}


	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}


	public String getUpdate_time() {
		return update_time;
	}


	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}

	
	
	
	//UserOrder---->OrderVo
	public void convertUserOrderToOrderVo(UserOrder order){
		
		this.oid = order.getOid();
		this.user_id = order.getUser_id();
		this.shipping_id = order.getShipping_id();
		this.order_no = order.getOrder_no();
		this.payment = order.getPayment().toString();
		Integer paymentType = order.getPayment_type();
		
		if(paymentType == PaymentTypeEnum.ONLINE.getType()){
			this.payment_type = "����֧��";
		}else if(paymentType == PaymentTypeEnum.OFFLINE.getType()){
			this.payment_type = "��������";
		}
		
		this.postage = order.getPostage();
		
		
		/**
		 * 	CANCLE(0,"�Ѿ�ȡ��"),
			UNPLAY(10,"δ����"),
			PAY(20,"�Ѹ���"),
			SEND(40,"�ѷ���"),
			SUCCESS(50,"���׳ɹ�"),
			CLOSE(60,"���׹ر�");
		 */
		
		Integer status = order.getStatus();
		
		if(status == OrderStatusEnum.CANCLE.getStatus()){
			this.status = "��ȡ��";
		}else if(status == OrderStatusEnum.CLOSE.getStatus()){
			this.status = "���׹ر�";
		}else if(status == OrderStatusEnum.PAY.getStatus()){
			this.status = "�Ѹ���";
		}else if(status == OrderStatusEnum.SEND.getStatus()){
			this.status = "�ѷ���";
		}else if(status == OrderStatusEnum.UNPLAY.getStatus()){
			this.status = "δ����";
		}else if(status == OrderStatusEnum.SUCCESS.getStatus()){
			this.status = "���׳ɹ�";
		}
		
		
		Date create_time = order.getCreate_time();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		this.create_time = df.format(create_time.getTime());
		this.update_time = df.format(order.getUpdate_time().getTime());
	}
	
	
}
