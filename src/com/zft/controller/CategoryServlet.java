package com.zft.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zft.entity.Category;
import com.zft.entity.PageModel;
import com.zft.entity.Product;
import com.zft.service.CategoryService;
import com.zft.service.ProductService;
import com.zft.serviceImpl.CategoryServiceImpl;
import com.zft.serviceImpl.ProductServiceImpl;

public class CategoryServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		List<Category> Categorylist = null;
//		CategoryService categoryService = new CategoryServiceImpl();
//		Categorylist = categoryService.findAll();
//		request.setAttribute("Category", Categorylist);
//		request.getRequestDispatcher("category.jsp").forward(request, response);
		String pageNo = request.getParameter("pageNo");
		CategoryService categoryService = new CategoryServiceImpl();
		PageModel<Category> pageModel = categoryService.findAll(Integer.parseInt(pageNo), 5);
		
		request.setAttribute("pageModel", pageModel);
		request.getRequestDispatcher("category.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}
	
}
