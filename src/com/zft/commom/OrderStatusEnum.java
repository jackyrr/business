package com.zft.commom;

public enum OrderStatusEnum {
	
	CANCLE(0,"已经取消"),
	UNPLAY(10,"未付款"),
	PAY(20,"已付款"),
	SEND(40,"已发货"),
	SUCCESS(50,"交易成功"),
	CLOSE(60,"交易关闭");
	
	private int status;
	private String message;
	
	private OrderStatusEnum(int status, String message) {
		this.status = status;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	 
	
	
}
