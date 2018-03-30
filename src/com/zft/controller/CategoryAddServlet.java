package com.zft.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zft.entity.Category;
import com.zft.service.CategoryService;
import com.zft.serviceImpl.CategoryServiceImpl;

public class CategoryAddServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 CategoryService categoryService = new CategoryServiceImpl();
		 int parent_id = Integer.parseInt(request.getParameter("parent_id"));
		 String name = request.getParameter("name");
		 int status = Integer.parseInt(request.getParameter("status"));
		 int sort_order = Integer.parseInt(request.getParameter("sort_order"));
		 Category category = new Category();
		 category.setParent_id(parent_id);
		 category.setName(name);
		 category.setSort_order(sort_order);
		 category.setStatus(status);
		 int count = categoryService.addCategory(category);
		 System.out.println(count);
		 if(count>0){
			 //添加成功
			 request.getRequestDispatcher("category.do?pageNo=1").forward(request, response);
		 }else{
			 //添加失败
			 System.out.println("=======");
		 }
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
}
