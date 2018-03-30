package com.zft.service;

import java.util.List;

import com.zft.entity.PageModel;
import com.zft.entity.Product;

public interface ProductService {
	
	//分页查询所有的商品
	public PageModel<Product> findAll(int pageNo,int pageSize);
	
	//查询所有商品
	
	public List<Product> findAll();
	
	//find some product
	public Product findProduct(int id); 
	
	//根据ID删除商品
	
	public int deleteProduct(int id);
	
	//add product
	
	public int addProduct(Product product);
	
	
	//update product massage
	
	public int modifyProduct(Product product);
	
	
	
}
