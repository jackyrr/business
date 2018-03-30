package com.zft.controller;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zft.entity.Product;
import com.zft.service.ProductService;
import com.zft.serviceImpl.ProductServiceImpl;

@WebServlet("/addProduct.do")
public class ProductAddServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService productService = new ProductServiceImpl();
		String category_id = request.getParameter("category_id");
		
		String subtitle = request.getParameter("subtitle");
		String name = request.getParameter("name");
		String main_image = request.getParameter("main_image");
		String sub_images = request.getParameter("sub_images");
		String detail = request.getParameter("detail");
		String _price = request.getParameter("price");
		BigDecimal price = new BigDecimal(_price);
		String stock = request.getParameter("stock");
		String status = request.getParameter("status");
		Product product = new Product(Integer.parseInt(category_id), name, subtitle, main_image, sub_images, detail, price, Integer.parseInt(stock), Integer.parseInt(status));
		System.out.println(product);
		int count = productService.addProduct(product);
		if(count>0){
			//add succ
			System.out.println("tiaozhuan");
			request.getRequestDispatcher("product.do?pageNo=1").forward(request, response);
		}else{
			//add fail
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
