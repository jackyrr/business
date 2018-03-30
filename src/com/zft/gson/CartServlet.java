package com.zft.gson;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.zft.constants.Consts;
import com.zft.entity.Cart;
import com.zft.entity.PageModel;
import com.zft.entity.User;
import com.zft.entity.vo.CartCheckedVo;
import com.zft.service.CartDaoMybatisService;
import com.zft.serviceImpl.CartDaoMybatisServiceImpl;


@WebServlet("/cartGson.do")
public class CartServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(Consts.CURRENTUSER);
		PrintWriter pw = response.getWriter();
		String operation = request.getParameter("operation");
		CartDaoMybatisService cartDaoMybatisService = new CartDaoMybatisServiceImpl();
		//����js��ߵķ�����
		String callback = request.getParameter("callback");
		if(operation.equals("1")){//��ѯ
			
			int pageNo = Integer.parseInt(request.getParameter("pageNo"));
			PageModel<Cart> pageModel = cartDaoMybatisService.findCartByPage(user.getId(), pageNo, 3);
			Gson gson = new Gson();
			String result = gson.toJson(pageModel);
			System.out.println(result);
			pw.write(callback+"("+result+")");
		}else if(operation.equals("2")){//ͳ����Ʒ����
			int result = cartDaoMybatisService.findAllProductNumber(user.getId());	
			String json = "{\"totalCount\":"+result+"}";
			pw.write(callback+"("+json+")");
			
		}else if(operation.equals("3")){//ɾ��
			String product_id = request.getParameter("product_id");
			try{
				int productid = Integer.parseInt(product_id);
				PageModel<Cart> carts = cartDaoMybatisService.deleteCartByProductId(user.getId(), productid);
				Gson gson = new Gson();
				String result = gson.toJson(carts);
				pw.write(callback+"("+result+")");
			}catch(NumberFormatException e){
				e.printStackTrace();
				
			}
			
		}else if(operation.equals("4")){// ȫѡ     ȡ��ȫѡ
			
/*			CartCheckedVo vo = cartDaoMybatisService.checkOrUncheckedProduct(user.getId(), request);
			
			Gson gson = new Gson();
			String json = gson.toJson(vo);
			pw.write(callback+"("+json+")");*/
			
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	
}
