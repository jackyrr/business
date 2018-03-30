package com.zft.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zft.constants.Consts;
import com.zft.entity.PageModel;
import com.zft.entity.User;
import com.zft.entity.UserOrder;
import com.zft.entity.vo.OrderItemVo;
import com.zft.entity.vo.OrderVo;
import com.zft.service.OrderService;
import com.zft.serviceImpl.OrderServiceImpl;

@WebServlet("/order.do")
public class OrderServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Consts.CURRENTUSER);
		
		
		String option = request.getParameter("option");
		if(option == null || "".equals(option)){
			try {
				throw new Exception("option参数必须传递");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if("1".equals(option)){//下单

			if(user!=null){
				OrderService orderService = new OrderServiceImpl();
				orderService.createOrder(user.getId(), request);
			}
		}else if("2".equals(option)){//分页查询
			OrderService orderService = new OrderServiceImpl();
			PageModel<OrderVo> pageModel = orderService.findUserOrderByPage(2, request);
			System.out.println(pageModel);
			session.setAttribute("pageModel", pageModel);
			response.sendRedirect("http://localhost:8080/zhangfengtan/order.jsp");
		}else if("3".equals(option)){//查看详情
			String order_no = request.getParameter("order_no");
			OrderService orderService = new OrderServiceImpl();
			List<OrderItemVo> items = orderService.findAllUserOrderItems(Long.parseLong(order_no));
			session.setAttribute("vo", items);
			response.sendRedirect("http://localhost:8080/zhangfengtan/showOrderItems.jsp");
		}else if("4".equals(option)){//根据订单号查询某一个订单
			String order_no = request.getParameter("inputOrder_no");
			OrderService orderService = new OrderServiceImpl();
			UserOrder order = orderService.findUserOrderDetailByOrderNo(Long.parseLong(order_no));
			String create_time = new SimpleDateFormat("yyyy-MM-dd").format(order.getCreate_time());
			String update_time = new SimpleDateFormat("yyyy-MM-dd").format(order.getUpdate_time());
			session.setAttribute("create_time", create_time);
			session.setAttribute("update_time", update_time);
			session.setAttribute("order", order);
			response.sendRedirect("http://localhost:8080/zhangfengtan/showOneOrder.jsp");
		}else if("5".equals(option)){//修改订单状态
			String status = request.getParameter("status");
			String order_no = request.getParameter("order_no");
			OrderService orderService = new OrderServiceImpl();
			int result = orderService.updateOrderStatusByOrderNo(Long.parseLong(order_no), Integer.parseInt(status));
			
			if(result>0){
				response.sendRedirect("http://localhost:8080/zhangfengtan/order.do?option=2");
			}
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
}
