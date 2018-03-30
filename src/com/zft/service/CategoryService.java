package com.zft.service;

import java.util.List;

import com.zft.entity.Category;
import com.zft.entity.PageModel;
import com.zft.entity.Product;

public interface CategoryService {
	
	
	//分页查询所有的商品类别
	public PageModel<Category> findAll(int pageNo,int pageSize);
	
	//查询所有的商品类别
	public List<Category> findAll();
	
	
	//根据ID删除商品类别
	
	public int deleteCategory(int id);
	
	
	//添加商品类别
	
	public int addCategory(Category category);
	
	
	//修改商品类别信息
	public int modifyCategory(Category category);
	
	
	//根据ID查询指定的商品类别
	
	public Category findCategory(int id);
	
}
