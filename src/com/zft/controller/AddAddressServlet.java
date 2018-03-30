package com.zft.controller;

import java.io.IOException;
import java.util.Date;

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

@WebServlet("/addAddress.do")
public class AddAddressServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(Consts.CURRENTUSER);
		String receiver_name = request.getParameter("receiver_name");
		String receiver_phone = request.getParameter("receiver_phone");
		String receiver_mobile = request.getParameter("receiver_mobile");
		String receiver_province = request.getParameter("receiver_province");
		String receiver_city = request.getParameter("receiver_city");
		String receiver_district = request.getParameter("receiver_district");
		String receiver_address = request.getParameter("receiver_address");
		String receiver_zip = request.getParameter("receiver_zip");
		Address address = new Address(user.getId(), receiver_name, receiver_phone, receiver_mobile, receiver_province, receiver_city, receiver_district, receiver_address, receiver_zip, null, null);
		
		
		AddressDaoMybatisService addressDaoMybatisService = new AddressDaoMybatisServiceImpl();
		int count = addressDaoMybatisService.addAddress(user.getId(), address);
		if(count>0){
			response.sendRedirect("http://localhost:8080/zhangfengtan/address.do?pageNo=1");
		}		
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
}
