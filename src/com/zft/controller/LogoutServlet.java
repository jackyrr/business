package com.zft.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zft.constants.Consts;

@WebServlet("/Logout.do")
public class LogoutServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//将需要将登陆信息user从会话中移除
		HttpSession session = request.getSession();
		session.removeAttribute(Consts.CURRENTUSER);
		
		//把username和password的cookie移除
		
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals(Consts.TOKEN_COOKIE)){
					Cookie cookie2 = new Cookie(cookie.getName(), cookie.getValue());
					cookie2.setMaxAge(0);
					cookie2.setPath(request.getContextPath());
					response.addCookie(cookie2);
				}
			}
		}
		//页面跳转到登录页面
		String result = request.getContextPath()+"/login.jsp";
		response.getWriter().print("<script>top.location.href=\""+result+"\"</script>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
}
