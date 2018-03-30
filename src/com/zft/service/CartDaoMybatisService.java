package com.zft.service;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.zft.entity.Cart;
import com.zft.entity.PageModel;
import com.zft.entity.vo.CartCheckedVo;

public interface CartDaoMybatisService {

	public int addProductToCart(Integer userid,Integer productid,int quantity);
	
	
	/**
	 *分页查询所有的购物车商品 
	 */
	public PageModel<Cart> findCartByPage(Integer userid, Integer pageNo, Integer pageSize);
	
	
	/**
	 * 移除某个购物车中的商品
	 */
	public PageModel<Cart> deleteCartByProductId(Integer userid,Integer productid);
	
	/**
	 * 增加商品数量
	 * @param userid
	 * @param productid
	 * @param quantity
	 * @return
	 */
	public int increaseCartByProductId(Integer userid,Integer productid);
	
	
	/**
	 * 减少商品数量
	 * @param userid
	 * @param productid
	 * @param quantity
	 * @return
	 */
	public int reduceCartByProductId(Integer userid,Integer productid);
	
	/**
	 * 选择  取消  全选  取消全选
	 * @param userid
	 * @param productid
	 * @param checked
	 * @return
	 */
	public int checkOrUncheckedProduct(Integer userid,int productid,int checked);
	
	/**
	 *所有商品数量
	 * @param userid
	 * @return
	 */
	public int findAllProductNumber(Integer userid);
	
}
