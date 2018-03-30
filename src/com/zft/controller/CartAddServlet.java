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

@WebServlet("/cartAdd.do")
public class CartAddServlet extends HttpServlet{
	
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		/**
		 * opreationType  `
		 * 1:分页列表
		 * 2：
		 */
		String opreation = request.getParameter("opreationType");
		
		
	
		
		String product_id = request.getParameter("id");
		System.out.println(product_id);
		int productid = Integer.parseInt(product_id);
		
		String _quantity = request.getParameter("quantity");
		System.out.println(_quantity);
		int quantity = Integer.parseInt(_quantity);
		
		HttpSession session = request.getSession();
		
		User user = (User) session.getAttribute(Consts.CURRENTUSER);
		
		if(user==null){
			response.sendRedirect("http://localhost:8080/zhangfengtan/login.jsp");
		}else{
			CartDaoMybatisService cartDaoMybatisService = new CartDaoMybatisServiceImpl();
			int count = cartDaoMybatisService.addProductToCart(user.getId(), productid, quantity);
			
			if(count>0){
				// add succ  跳转到分页列表
				response.sendRedirect("http://localhost:8080/zhangfengtan/cart.do?pageNo=1");
			}else{
				//add fail
				System.out.println("添加失败");
			}
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	
}
