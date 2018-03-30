package com.zft.dao;

import java.util.List;

import com.zft.entity.Category;
import com.zft.entity.PageModel;

public interface CategoryDao {
	
	
	//分页查询所有商品类别
	public PageModel<Category> findAllByPage(int pageNo,int pageSize);
	
	//查找所有的商品类别
	public List<Category> findAll();
	
	//根据ID查找指定的商品
	public Category findCategory(int id);
	
	
	//根据ID删除指定的商品类别
	public int deleteCategory(int id);

	//添加商品类别
	public int addCategory(Category category);
	
	
	//修改商品类别信息
	public int modifyCategory(Category category);
	
	
}
