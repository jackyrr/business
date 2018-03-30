package com.zft.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zft.constants.Consts;
import com.zft.entity.User;
import com.zft.service.CartDaoMybatisService;
import com.zft.serviceImpl.CartDaoMybatisServiceImpl;

@WebServlet("/cartModify.do")
public class CartModifyServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String operation = request.getParameter("operation");
		String productid = request.getParameter("productid");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Consts.CURRENTUSER);
		
		CartDaoMybatisService cartDaoMybatisService = new CartDaoMybatisServiceImpl();
		if(operation.equals("increase")){
			
			//增加商品数量
			int count = cartDaoMybatisService.increaseCartByProductId(user.getId(), Integer.parseInt(productid));
			if(count>0){
				response.sendRedirect("http://localhost:8080/zhangfengtan/cart.do?pageNo=1");
			}
		}else if(operation.equals("reduce")){
			String _quantity = request.getParameter("quantity");
			int quantity = Integer.parseInt(_quantity);
			//减少商品数量
			if(quantity>1){
				int count = cartDaoMybatisService.reduceCartByProductId(user.getId(), Integer.parseInt(productid));
				if(count>0){
					response.sendRedirect("http://localhost:8080/zhangfengtan/cart.do?pageNo=1");
				}
			}else{
				response.sendRedirect("http://localhost:8080/zhangfengtan/cart.do?pageNo=1");
			}
		
		}
		
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	
}
