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

public class ModifypageServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Category category = null;
		String result = request.getParameter("id");
		CategoryService categoryService = new CategoryServiceImpl();
		category = categoryService.findCategory(Integer.parseInt(result));
		List<Category> list = categoryService.findAll();
		request.setAttribute("category", category);
		request.setAttribute("Categorylist", list);
		request.getRequestDispatcher("modifyCate.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
}
