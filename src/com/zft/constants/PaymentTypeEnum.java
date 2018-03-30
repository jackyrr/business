package com.zft.constants;

public enum PaymentTypeEnum {
	
	
	
	ONLINE(1,"在线支付"),
	OFFLINE(2,"货到付款");
	
	private int type;
	private String message;
	
	private PaymentTypeEnum(int type,String message){
		this.type = type;
		this.message = message;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
	
	
}
