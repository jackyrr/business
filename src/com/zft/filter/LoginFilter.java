package com.zft.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zft.constants.Consts;
import com.zft.entity.User;
import com.zft.service.ILoginService;
import com.zft.serviceImpl.LoginServiceImpl;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/succ.jsp")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
    	
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest _request, ServletResponse _response, FilterChain chain) throws IOException, ServletException {
		
		
		//向下转型
		HttpServletRequest request = (HttpServletRequest)_request;
		HttpServletResponse response = (HttpServletResponse)_response;
		
		//获取session
		HttpSession session = request.getSession();
		
		
		//判断用户token是否存在
		String token = null;
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals(Consts.TOKEN_COOKIE)){
					token = cookie.getValue();
				}
			}
		}
		
		if(token!=null){
			ILoginService loginService = new LoginServiceImpl();
			User user = null;
			user = loginService.findUserByToken(token);
			if(user!=null){
				session.setAttribute(Consts.CURRENTUSER, user);
				chain.doFilter(request, response);
			}else{
				response.sendRedirect("http://localhost:8080/zhangfengtan/login.jsp");
			}
		}else{
			response.sendRedirect("http://localhost:8080/zhangfengtan/login.jsp");
		}
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
