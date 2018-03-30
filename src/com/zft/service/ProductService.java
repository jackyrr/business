package com.zft.service;

import java.util.List;

import com.zft.entity.PageModel;
import com.zft.entity.Product;

public interface ProductService {
	
	//��ҳ��ѯ���е���Ʒ
	public PageModel<Product> findAll(int pageNo,int pageSize);
	
	//��ѯ������Ʒ
	
	public List<Product> findAll();
	
	//find some product
	public Product findProduct(int id); 
	
	//����IDɾ����Ʒ
	
	public int deleteProduct(int id);
	
	//add product
	
	public int addProduct(Product product);
	
	
	//update product massage
	
	public int modifyProduct(Product product);
	
	
	
}
