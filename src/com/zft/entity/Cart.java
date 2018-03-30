package com.zft.entity;

import java.io.Serializable;
import java.util.Date;

public class Cart implements Serializable{
	private Integer cid;
	//private int user_id;
	private User user;
	//private int product_id;
	private Product product;
	private int quantity;
	private int checked;//是否被选择  1：一选择    0：未选中
	private Date create_time;
	private Date update_time;
	
	public Cart(){
		
	}

	public Cart(int quantity, int checked, Date create_time, Date update_time) {
		super();
		this.quantity = quantity;
		this.checked = checked;
		this.create_time = create_time;
		this.update_time = update_time;
	}

	

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getChecked() {
		return checked;
	}

	public void setChecked(int checked) {
		this.checked = checked;
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
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "["+"id="+this.getCid()+" user="+user+" product="+product+" quantity="+this.getQuantity()
		+" checked="+this.getChecked()+" create_time="+this.getCreate_time()+" update_time="+this.getUpdate_time()+"]";
	}
	
	
	
}
