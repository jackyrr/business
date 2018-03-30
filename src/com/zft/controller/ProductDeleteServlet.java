package com.zft.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zft.entity.PageModel;
import com.zft.entity.Product;
import com.zft.service.ProductService;
import com.zft.serviceImpl.ProductServiceImpl;

public class ProductDeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println(id);
		ProductService productService = new ProductServiceImpl();
		int count = productService.deleteProduct(Integer.parseInt(id));
		if(count>0){
			//delete succ
			
			request.getRequestDispatcher("product.do").forward(request, response);
		}else{
			//delete fail
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
