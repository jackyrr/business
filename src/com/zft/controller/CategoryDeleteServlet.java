package com.zft.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zft.entity.Category;
import com.zft.service.CategoryService;
import com.zft.serviceImpl.CategoryServiceImpl;

public class CategoryDeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String result = request.getParameter("id");
		CategoryService categoryService = new CategoryServiceImpl();
		int count = categoryService.deleteCategory(Integer.parseInt(result));
		if(count>0){
			//删除成功  跳转到查询的servlet
//			List<Category> list = categoryService.findAll();
//			request.setAttribute("Category", list);
			request.getRequestDispatcher("category.do?pageNo=1").forward(request, response);
		}else{
			//删除失败
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	
}
