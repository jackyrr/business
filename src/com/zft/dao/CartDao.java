package com.zft.dao;

import java.util.List;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicInterface2;

import com.zft.entity.Cart;
import com.zft.entity.PageModel;

/**
 * 购物车管理
 * @author Administrator
 *
 */
public interface CartDao {
	/**
	 * 根据userID跟productID查询购物车信息
	 * @param userid
	 * @param productid
	 * @return Cart购物车对象
	 */
	public Cart findCartByUserIdAndProductId(Integer userid,Integer productid);
	
	
	/**
	 * 更新购物车中商品的数量
	 * @param userid
	 * @param productid
	 * @param quantity  商品数量
	 * @return int
	 */
	public int updateCartByUserIdAndProductId(Integer userid,Integer productid,int quantity);
	
	/**
	 * 用户将商品添加到购物车
	 * @param userid
	 * @param productid
	 * @param quantity  商品数量
	 * @return  int 
	 */
	public int addProductIntoCartByUserIdAndProductId(Integer userid,Integer productid,int quantity);
	
	
	
	/**
	 * 查看购物车商品
	 * @param userid
	 * @param pageNo
	 * @param pageSize
	 * @return PageModel<Cart>
	 */
	public PageModel<Cart> findCartByPage(Integer userid,Integer pageNo,Integer pageSize);
	
	
	/**
	 * 根据商品ID增加商品数量
	 * @param userid
	 * @param productid
	 * @param quantity
	 * @return
	 */
	public int increaseCartByProductId(Integer userid,Integer productid);
	
	/**
	 * 根据商品ID减少商品数量
	 * @param userid
	 * @param productid
	 * @param quantity
	 * @return
	 */
	public int reduceCartByProductId(Integer userid,Integer productid);
	/**
	 * 移除购物车中的某个商品
	 * @param userid
	 * @param productid
	 * @return
	 */
	public int deleteCartByProductId(Integer userid,Integer productid);
	
	/**
	 * 查询总的记录数
	 * @return
	 */
	public int findCartNumber();
	
	
	/**
	 * 查询在购物车里的所有产品数量
	 * @param userid
	 * @return
	 */
	public int findAllProductNumber(Integer userid);
	
	/**
	 * 选中  取消选中  全选   取消全选
	 * @param userid
	 * @param productid
	 * @param checked   1选中   0 取消选中
	 * @return
	 */
	public int checkOrUncheckedProduct(Integer userid,Integer productid,int checked);
	
	
	/**
	 * 查询某用户购物车中已选择的商品
	 * 
	 */
	List<Cart> findCartListByUserId(Integer userid);
	
	/**
	 * 删除用户选中的商品
	 * 
	 */
	public int deleteCheckedProductByUserId(Integer userid);
}
