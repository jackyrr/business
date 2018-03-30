package com.zft.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zft.entity.Category;
import com.zft.service.CategoryService;
import com.zft.serviceImpl.CategoryServiceImpl;

public class CategoryModifyServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 CategoryService categoryService = new CategoryServiceImpl();
		 int id = Integer.parseInt(request.getParameter("id"));
		 int parent_id = Integer.parseInt(request.getParameter("parent_id"));
		 String name = request.getParameter("name");
		 int status = Integer.parseInt(request.getParameter("status"));
		 int sort_order = Integer.parseInt(request.getParameter("sort_order"));
		 Category category = new Category();
		 category.setId(id);
		 category.setParent_id(parent_id);
		 category.setName(name);
		 category.setSort_order(sort_order);
		 category.setStatus(status);
		 int count = categoryService.modifyCategory(category);
		 System.out.println(count);
		 if(count>0){
			 //添加成功
			 request.getRequestDispatcher("category.do?pageNo=1").forward(request, response);
		 }else{
			 //添加失败
			 System.out.println("=======");
		 }

	}
	
}
