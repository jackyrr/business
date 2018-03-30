package com.zft.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zft.entity.User;
import com.zft.service.UserService;
import com.zft.serviceImpl.UserServiceImpl;


@WebServlet("/user.do")
public class UserServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		UserService userService = new UserServiceImpl();
		List<User> users = userService.findAllUser();
		
		session.setAttribute("User", users);
		response.sendRedirect("http://localhost:8080/zhangfengtan/showUser.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	
	
	
}
