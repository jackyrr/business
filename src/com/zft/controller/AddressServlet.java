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
import com.zft.entity.PageModel;
import com.zft.entity.User;
import com.zft.service.AddressDaoMybatisService;
import com.zft.serviceImpl.AddressDaoMybatisServiceImpl;


@WebServlet("/address.do")
public class AddressServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(Consts.CURRENTUSER);
		int pageNo = Integer.parseInt(request.getParameter("pageNo"));
		
		AddressDaoMybatisService addressDaoMybatisService = new AddressDaoMybatisServiceImpl();
		
		PageModel<Address> pageModel = addressDaoMybatisService.findUserAddress(pageNo, 5, user.getId());
		
		session.setAttribute("pageModel", pageModel);
		
		response.sendRedirect("http://localhost:8080/zhangfengtan/address.jsp");
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	}
	
	
	
	
}
