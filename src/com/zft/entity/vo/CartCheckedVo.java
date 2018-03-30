package com.zft.entity.vo;

import java.io.Serializable;

public class CartCheckedVo implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	
	/**
	 * 1:succ 
	 * 0:fail
	 */
	
	public static final Integer ERRNO_SUCC = 1;
	
	public static final Integer ERRNO_FAIL = 0;
	
	
	
	private Integer errno;
	
	private String message;
	
	private Integer product_id;//商品ID
	
	private Integer checked;//是否选中  1：选中  0：未选中
	
	
	
	
	public Integer getErrno() {
		return errno;
	}

	public void setErrno(Integer errno) {
		this.errno = errno;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public Integer getChecked() {
		return checked;
	}

	public void setChecked(Integer checked) {
		this.checked = checked;
	}

	@Override
	public String toString() {
		return "CartCheckedVo [product_id=" + product_id + ", checked=" + checked + "]";
	}
	
	
}
