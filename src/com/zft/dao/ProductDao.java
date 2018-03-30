package com.zft.dao;

import java.util.List;

import com.zft.entity.PageModel;
import com.zft.entity.Product;

public interface ProductDao {
	
	//分页查询所有的商品
	public PageModel<Product> findAllByPage(int pageNo,int pageSize);
	
	//查询所有商品
	public List<Product> findAll();
	
	//根据ID查询指定的商品
	public Product findProduct(int id);
	
	//根据ID删除指定的商品
	public int deleteProduct(int id);
	
	//修改商品信息
	public int modifyProduct(Product product);
	
	//添加商品
	public int addProduct(Product product);
	
	//根据商品ID查询商品库存
	public long getProductStock(Integer product_id);
	
	//减少商品库存
	public int reduceProductStock(Integer product_id,Integer quantity);
}
