package com.zft.serviceImpl;

import java.util.List;

import com.zft.dao.CategoryDao;
import com.zft.daoImpl.CategoryDaoImpl;
import com.zft.entity.Category;
import com.zft.entity.PageModel;
import com.zft.service.CategoryService;

public class CategoryServiceImpl implements CategoryService{

	CategoryDao categoryDao = new CategoryDaoImpl();
	@Override
	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	@Override
	public int deleteCategory(int id) {
		return categoryDao.deleteCategory(id);
	}

	@Override
	public int addCategory(Category category) {
		return categoryDao.addCategory(category);
	}

	@Override
	public int modifyCategory(Category category) {
		return categoryDao.modifyCategory(category);
	}

	@Override
	public Category findCategory(int id) {
		return categoryDao.findCategory(id);
	}

	@Override
	public PageModel<Category> findAll(int pageNo, int pageSize) {
		return categoryDao.findAllByPage(pageNo, pageSize);
	}
	
}
