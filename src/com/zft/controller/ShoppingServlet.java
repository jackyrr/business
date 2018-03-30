package com.zft.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zft.entity.PageModel;
import com.zft.entity.Product;
import com.zft.service.ProductService;
import com.zft.serviceImpl.ProductServiceImpl;

@WebServlet("/shopping.do")
public class ShoppingServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageNo = request.getParameter("pageNo");
		ProductService productService = new ProductServiceImpl();
		PageModel<Product> pageModel = productService.findAll(Integer.parseInt(pageNo), 5);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("pageModel", pageModel);
		response.sendRedirect("http://localhost:8080/zhangfengtan/shopping.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
}
