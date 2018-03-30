package com.zft.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class UserOrderItems implements Serializable{
	
	
	private Integer  uoid ;
	private Long  order_no ;
	private Integer  user_id ;
	private Integer  product_id ;// '商品id',
	private String  product_name ;//'商品名称',
	private String  product_image ;//'商品图片地址',
	private BigDecimal  current_unit_price ;//'生成订单时的商品金额,单位元,保留两位小数',
	private Integer  quantity ;//'商品数量',
	private BigDecimal  total_price ;// '商品总价,单位元,保留两位小数',
	private Date  create_time ;//
	private Date  update_time ;//
	
	public UserOrderItems(){
		
	}

	public UserOrderItems(Integer uoid, Long order_no, Integer user_id, Integer product_id, String product_name,
			String product_image, BigDecimal current_unit_price, Integer quantity, BigDecimal total_price,
			Date create_time, Date update_time) {
		super();
		this.uoid = uoid;
		this.order_no = order_no;
		this.user_id = user_id;
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_image = product_image;
		this.current_unit_price = current_unit_price;
		this.quantity = quantity;
		this.total_price = total_price;
		this.create_time = create_time;
		this.update_time = update_time;
	}

	public Integer getUoid() {
		return uoid;
	}

	public void setUoid(Integer uoid) {
		this.uoid = uoid;
	}

	public Long getOrder_no() {
		return order_no;
	}

	public void setOrder_no(Long order_no) {
		this.order_no = order_no;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_image() {
		return product_image;
	}

	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}

	public BigDecimal getCurrent_unit_price() {
		return current_unit_price;
	}

	public void setCurrent_unit_price(BigDecimal current_unit_price) {
		this.current_unit_price = current_unit_price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotal_price() {
		return total_price;
	}

	public void setTotal_price(BigDecimal total_price) {
		this.total_price = total_price;
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
		return "UserOrderItems [uoid=" + uoid + ", order_no=" + order_no + ", user_id=" + user_id + ", product_id="
				+ product_id + ", product_name=" + product_name + ", product_image=" + product_image
				+ ", current_unit_price=" + current_unit_price + ", quantity=" + quantity + ", total_price="
				+ total_price + ", create_time=" + create_time + ", update_time=" + update_time + "]";
	}
	
	
}
