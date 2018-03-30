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

@WebServlet("/cartChecked.do")
public class CartCheckedServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/**
		 * opreation 代表要进行的操作
		 * 1：全选
		 * 2：全部取消
		 * 3：单选
		 * 4：单个取消
		 */
		String productid = request.getParameter("productid");
		System.out.println(productid);
		String operation = request.getParameter("operation");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Consts.CURRENTUSER);
		CartDaoMybatisService cartDaoMybatisService = new CartDaoMybatisServiceImpl();
		if(operation.equals("1")){
			//全选
			int count = cartDaoMybatisService.checkOrUncheckedProduct(user.getId(), -1, 1);
			if(count>0){
				response.sendRedirect("http://localhost:8080/zhangfengtan/cart.do?pageNo=1");
			}
		}else if(operation.equals("2")){
			//全部取消
			int count = cartDaoMybatisService.checkOrUncheckedProduct(user.getId(), -1, 0);
			if(count>0){
				response.sendRedirect("http://localhost:8080/zhangfengtan/cart.do?pageNo=1");
			}
			
		}else if(operation.equals("3")){
			//单选
			int count = cartDaoMybatisService.checkOrUncheckedProduct(user.getId(), Integer.parseInt(productid), 1);
			if(count>0){
				response.sendRedirect("http://localhost:8080/zhangfengtan/cart.do?pageNo=1");
			}
		
		}else if(operation.equals("4")){
			//取消单选
			int count = cartDaoMybatisService.checkOrUncheckedProduct(user.getId(), Integer.parseInt(productid), 0);
			if(count>0){
				response.sendRedirect("http://localhost:8080/zhangfengtan/cart.do?pageNo=1");
			}
		}
		

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	
}
