package com.zft.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zft.dao.ProductDao;
import com.zft.daoImpl.ProductDaoImpl;
import com.zft.entity.Category;
import com.zft.entity.Product;
import com.zft.service.CategoryService;
import com.zft.service.ProductService;
import com.zft.serviceImpl.CategoryServiceImpl;
import com.zft.serviceImpl.ProductServiceImpl;

@WebServlet("/productAddpage.do")
public class ProductAddpageServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Category> Categorylist = null;
		CategoryService categoryService = new CategoryServiceImpl();
		Categorylist = categoryService.findAll();
		request.setAttribute("Category", Categorylist);
		request.getRequestDispatcher("addProduct.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
}
