package com.zft.dao;

import java.util.List;

import com.zft.entity.Category;
import com.zft.entity.PageModel;

public interface CategoryDao {
	
	
	//��ҳ��ѯ������Ʒ���
	public PageModel<Category> findAllByPage(int pageNo,int pageSize);
	
	//�������е���Ʒ���
	public List<Category> findAll();
	
	//����ID����ָ������Ʒ
	public Category findCategory(int id);
	
	
	//����IDɾ��ָ������Ʒ���
	public int deleteCategory(int id);

	//�����Ʒ���
	public int addCategory(Category category);
	
	
	//�޸���Ʒ�����Ϣ
	public int modifyCategory(Category category);
	
	
}
