package com.zft.dao;

import java.util.List;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicInterface2;

import com.zft.entity.Cart;
import com.zft.entity.PageModel;

/**
 * ���ﳵ����
 * @author Administrator
 *
 */
public interface CartDao {
	/**
	 * ����userID��productID��ѯ���ﳵ��Ϣ
	 * @param userid
	 * @param productid
	 * @return Cart���ﳵ����
	 */
	public Cart findCartByUserIdAndProductId(Integer userid,Integer productid);
	
	
	/**
	 * ���¹��ﳵ����Ʒ������
	 * @param userid
	 * @param productid
	 * @param quantity  ��Ʒ����
	 * @return int
	 */
	public int updateCartByUserIdAndProductId(Integer userid,Integer productid,int quantity);
	
	/**
	 * �û�����Ʒ��ӵ����ﳵ
	 * @param userid
	 * @param productid
	 * @param quantity  ��Ʒ����
	 * @return  int 
	 */
	public int addProductIntoCartByUserIdAndProductId(Integer userid,Integer productid,int quantity);
	
	
	
	/**
	 * �鿴���ﳵ��Ʒ
	 * @param userid
	 * @param pageNo
	 * @param pageSize
	 * @return PageModel<Cart>
	 */
	public PageModel<Cart> findCartByPage(Integer userid,Integer pageNo,Integer pageSize);
	
	
	/**
	 * ������ƷID������Ʒ����
	 * @param userid
	 * @param productid
	 * @param quantity
	 * @return
	 */
	public int increaseCartByProductId(Integer userid,Integer productid);
	
	/**
	 * ������ƷID������Ʒ����
	 * @param userid
	 * @param productid
	 * @param quantity
	 * @return
	 */
	public int reduceCartByProductId(Integer userid,Integer productid);
	/**
	 * �Ƴ����ﳵ�е�ĳ����Ʒ
	 * @param userid
	 * @param productid
	 * @return
	 */
	public int deleteCartByProductId(Integer userid,Integer productid);
	
	/**
	 * ��ѯ�ܵļ�¼��
	 * @return
	 */
	public int findCartNumber();
	
	
	/**
	 * ��ѯ�ڹ��ﳵ������в�Ʒ����
	 * @param userid
	 * @return
	 */
	public int findAllProductNumber(Integer userid);
	
	/**
	 * ѡ��  ȡ��ѡ��  ȫѡ   ȡ��ȫѡ
	 * @param userid
	 * @param productid
	 * @param checked   1ѡ��   0 ȡ��ѡ��
	 * @return
	 */
	public int checkOrUncheckedProduct(Integer userid,Integer productid,int checked);
	
	
	/**
	 * ��ѯĳ�û����ﳵ����ѡ�����Ʒ
	 * 
	 */
	List<Cart> findCartListByUserId(Integer userid);
	
	/**
	 * ɾ���û�ѡ�е���Ʒ
	 * 
	 */
	public int deleteCheckedProductByUserId(Integer userid);
}
