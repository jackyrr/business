package com.zft.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zft.commom.MD5Utils;
import com.zft.constants.Consts;
import com.zft.entity.User;
import com.zft.service.ILoginService;
import com.zft.serviceImpl.LoginServiceImpl;

public class MyServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决中文编码问题
		
		response.setContentType("text/html;charset=UTF-8");   
		//创建一个会话
		HttpSession session = request.getSession();
		
		//获取表单参数
		String _username = request.getParameter("username");
		String _password = request.getParameter("password");
		
		//对获取的密码进行加密
		String password = null;
		if(_password!=null){
			password = MD5Utils.GetMD5Code(_password);
		}
		
		//调用service层
		ILoginService loginService = new LoginServiceImpl();
		User user = null;
		user = loginService.login(_username, password);
		if(user!=null){//succ
			//令牌
			String token = MD5Utils.GetMD5Code(user.getUsername()+user.getPassword());
			Cookie token_cookie = new Cookie(Consts.TOKEN_COOKIE,token);
			System.out.println(user.getId());
			
			
			token_cookie.setMaxAge(7*24*3600);
			token_cookie.setPath(request.getContextPath());
			response.addCookie(token_cookie);
			loginService.updateTokenByUserId(user.getId(), token);
			
			//重定向
			session.setAttribute(Consts.CURRENTUSER, user);
			
			//判断是管理员还是用户登录
			if(user.getRole()==0){
				//管理员登录 跳转到管理员界面
				response.sendRedirect("http://localhost:8080/zhangfengtan/succ.jsp");
			}else{
				//用户登录 跳转到用户界面
				response.sendRedirect("http://localhost:8080/zhangfengtan/shopping.do?pageNo=1");
			}
			
		}else{
			//fail
			request.getRequestDispatcher("fail.jsp").forward(request, response);
		}
	}

	@Override
	public void init() throws ServletException {
		super.init();
	}
	
	
	
}
