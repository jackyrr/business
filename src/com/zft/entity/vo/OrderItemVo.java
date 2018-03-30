package com.zft.entity.vo;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.zft.daoImpl.UserDaoImpl;
import com.zft.daoImpl.UserOrderDaoImpl;
import com.zft.entity.User;
import com.zft.entity.UserOrderItems;

public class OrderItemVo {
	
	private Integer  uoid ;
	private Long  order_no ;
	private User  user ;
	private Integer  product_id ;// '商品id',
	private String  product_name ;//'商品名称',
	private String  product_image ;//'商品图片地址',
	private BigDecimal  current_unit_price ;//'生成订单时的商品金额,单位元,保留两位小数',
	private Integer  quantity ;//'商品数量',
	private BigDecimal  total_price ;// '商品总价,单位元,保留两位小数',
	private String  create_time ;//
	private String  update_time ;//
	
	public OrderItemVo(){
		
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
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
	
	public void convertOrderItemsToOrderItemVo(UserOrderItems item){
		
			this.uoid = item.getUoid();
			this.order_no = item.getOrder_no();
			this.user = new UserDaoImpl().findOneUser(item.getUser_id());
			this.product_id = item.getProduct_id();
			this.product_name = item.getProduct_name();
			this.product_image = item.getProduct_image();
			this.current_unit_price = item.getCurrent_unit_price();
			this.quantity = item.getQuantity();
			this.total_price = item.getTotal_price();
			this.create_time = new SimpleDateFormat("yyyy-MM-dd").format(item.getCreate_time());
			this.update_time = new SimpleDateFormat("yyyy-MM-dd").format(item.getUpdate_time());
		
	} 
	
	
}
