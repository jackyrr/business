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
import com.zft.service.AddressDaoMybatisService;
import com.zft.serviceImpl.AddressDaoMybatisServiceImpl;

@WebServlet("/addressDelete.do")
public class AddressDeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("id").length());
		int id = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		AddressDaoMybatisService addressDaoMybatisService = new AddressDaoMybatisServiceImpl();
		User user = (User) session.getAttribute(Consts.CURRENTUSER);
		int count = addressDaoMybatisService.deleteAddressByUserid(user.getId(), id);
		if(count>0){
			response.sendRedirect("http://localhost:8080/zhangfengtan/address.do?pageNo=1");
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	
}
