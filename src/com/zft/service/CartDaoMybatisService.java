package com.zft.service;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.zft.entity.Cart;
import com.zft.entity.PageModel;
import com.zft.entity.vo.CartCheckedVo;

public interface CartDaoMybatisService {

	public int addProductToCart(Integer userid,Integer productid,int quantity);
	
	
	/**
	 *��ҳ��ѯ���еĹ��ﳵ��Ʒ 
	 */
	public PageModel<Cart> findCartByPage(Integer userid, Integer pageNo, Integer pageSize);
	
	
	/**
	 * �Ƴ�ĳ�����ﳵ�е���Ʒ
	 */
	public PageModel<Cart> deleteCartByProductId(Integer userid,Integer productid);
	
	/**
	 * ������Ʒ����
	 * @param userid
	 * @param productid
	 * @param quantity
	 * @return
	 */
	public int increaseCartByProductId(Integer userid,Integer productid);
	
	
	/**
	 * ������Ʒ����
	 * @param userid
	 * @param productid
	 * @param quantity
	 * @return
	 */
	public int reduceCartByProductId(Integer userid,Integer productid);
	
	/**
	 * ѡ��  ȡ��  ȫѡ  ȡ��ȫѡ
	 * @param userid
	 * @param productid
	 * @param checked
	 * @return
	 */
	public int checkOrUncheckedProduct(Integer userid,int productid,int checked);
	
	/**
	 *������Ʒ����
	 * @param userid
	 * @return
	 */
	public int findAllProductNumber(Integer userid);
	
}
