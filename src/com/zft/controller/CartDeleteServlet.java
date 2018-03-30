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

@WebServlet("/cartDelete.do")
public class CartDeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
/*		String productid = request.getParameter("productid");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Consts.CURRENTUSER);
		CartDaoMybatisService cartDaoMybatisService = new CartDaoMybatisServiceImpl();
		int count = cartDaoMybatisService.deleteCartByProductId(user.getId(), Integer.parseInt(productid));
		System.out.println(count);
		if(count>0){
			response.sendRedirect("http://localhost:8080/zhangfengtan/cart.do?pageNo=1");
		}*/
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	
	
	
}
