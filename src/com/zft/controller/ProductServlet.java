package com.zft.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zft.entity.PageModel;
import com.zft.entity.Product;
import com.zft.service.ProductService;
import com.zft.serviceImpl.ProductServiceImpl;

public class ProductServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		
		String pageNo = request.getParameter("pageNo");
		ProductService productService = new ProductServiceImpl();
		PageModel<Product> pageModel = productService.findAll(Integer.parseInt(pageNo), 5);
		
		session.setAttribute("pageModel", pageModel);
		response.sendRedirect("http://localhost:8080/zhangfengtan/product.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
}
