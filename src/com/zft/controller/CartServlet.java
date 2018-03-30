package com.zft.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zft.constants.Consts;
import com.zft.entity.Cart;
import com.zft.entity.PageModel;
import com.zft.entity.User;
import com.zft.service.CartDaoMybatisService;
import com.zft.serviceImpl.CartDaoMybatisServiceImpl;


@WebServlet("/cart.do")
public class CartServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(Consts.CURRENTUSER);
		int pageNo = Integer.parseInt(request.getParameter("pageNo"));
		CartDaoMybatisService cartDaoMybatisService = new CartDaoMybatisServiceImpl();
		PageModel<Cart> pageModel = cartDaoMybatisService.findCartByPage(user.getId(), pageNo, 5);
		session.setAttribute("pageModel", pageModel);
		
		response.sendRedirect("http://localhost:8080/zhangfengtan/cart.jsp");
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	
}
