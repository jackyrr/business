package com.zft.service;

import java.util.List;

import com.zft.entity.Category;
import com.zft.entity.PageModel;
import com.zft.entity.Product;

public interface CategoryService {
	
	
	//��ҳ��ѯ���е���Ʒ���
	public PageModel<Category> findAll(int pageNo,int pageSize);
	
	//��ѯ���е���Ʒ���
	public List<Category> findAll();
	
	
	//����IDɾ����Ʒ���
	
	public int deleteCategory(int id);
	
	
	//�����Ʒ���
	
	public int addCategory(Category category);
	
	
	//�޸���Ʒ�����Ϣ
	public int modifyCategory(Category category);
	
	
	//����ID��ѯָ������Ʒ���
	
	public Category findCategory(int id);
	
}
