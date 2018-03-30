package com.zft.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zft.entity.Category;
import com.zft.service.CategoryService;
import com.zft.serviceImpl.CategoryServiceImpl;

public class AddpageServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Category> Categorylist = null;
		CategoryService categoryService = new CategoryServiceImpl();
		Categorylist = categoryService.findAll();
		request.setAttribute("Category", Categorylist);
		request.getRequestDispatcher("addCategory.jsp").forward(request, response);
	}
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
