package com.zft.dao;

import java.util.List;

import com.zft.entity.PageModel;
import com.zft.entity.Product;

public interface ProductDao {
	
	//��ҳ��ѯ���е���Ʒ
	public PageModel<Product> findAllByPage(int pageNo,int pageSize);
	
	//��ѯ������Ʒ
	public List<Product> findAll();
	
	//����ID��ѯָ������Ʒ
	public Product findProduct(int id);
	
	//����IDɾ��ָ������Ʒ
	public int deleteProduct(int id);
	
	//�޸���Ʒ��Ϣ
	public int modifyProduct(Product product);
	
	//�����Ʒ
	public int addProduct(Product product);
	
	//������ƷID��ѯ��Ʒ���
	public long getProductStock(Integer product_id);
	
	//������Ʒ���
	public int reduceProductStock(Integer product_id,Integer quantity);
}
