package com.zft.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zft.constants.Consts;
import com.zft.entity.Address;
import com.zft.entity.User;
import com.zft.service.AddressDaoMybatisService;
import com.zft.serviceImpl.AddressDaoMybatisServiceImpl;

@WebServlet("/addressModifyPage.do")
public class AddressModifyPageServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession  session = request.getSession();
		String parameter = request.getParameter("id");
		int id = Integer.parseInt(parameter);
		User user = (User) session.getAttribute(Consts.CURRENTUSER);
		
		AddressDaoMybatisService addressDaoMybatisService = new AddressDaoMybatisServiceImpl();
		Address address = addressDaoMybatisService.findOneAddress(user.getId(), id);
		session.setAttribute("address", address);
		session.setAttribute("id", id);
		response.sendRedirect("http://localhost:8080/zhangfengtan/modifyAddress.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	
}
