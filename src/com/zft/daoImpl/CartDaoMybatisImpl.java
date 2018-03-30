package com.zft.daoImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.zft.commom.MyBatisUtils;
import com.zft.dao.CartDao;
import com.zft.entity.Cart;
import com.zft.entity.PageModel;

public class CartDaoMybatisImpl implements CartDao{

	
	@Override
	public Cart findCartByUserIdAndProductId(Integer userid, Integer productid) {
		SqlSessionFactory factory = MyBatisUtils.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		Map<String, Integer> map = new HashMap<String,Integer>();
		map.put("userid", userid);
		map.put("productid", productid);
		Cart cart = session.selectOne("com.zft.entity.Cart.findCartByUserIdAndProductId", map);
		MyBatisUtils.close(session);
		return cart;
	}

	@Override
	public int updateCartByUserIdAndProductId(Integer userid, Integer productid, int quantity) {
		SqlSessionFactory factory = MyBatisUtils.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		Map<String, Integer> map = new HashMap<String,Integer>();
		map.put("userid", userid);
		map.put("productid", productid);
		map.put("quantity", quantity);
		int count = session.update("com.zft.entity.Cart.updateCartByUserIdAndProductId", map);
		session.commit();
		MyBatisUtils.close(session);
		return count;
	}

	@Override
	public int addProductIntoCartByUserIdAndProductId(Integer userid, Integer productid, int quantity) {
		SqlSessionFactory factory = MyBatisUtils.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		Map<String, Integer> map = new HashMap<String,Integer>();
		map.put("userid", userid);
		map.put("productid", productid);
		map.put("quantity", quantity);
		
		int count = session.insert("com.zft.entity.Cart.addProductIntoCartByUserIdAndProductId", map);
		session.commit();
		MyBatisUtils.close(session);
		return count;
	}
	
	/**
	 * 查询总的记录数
	 */
	@Override
	public int findCartNumber() {
		SqlSessionFactory factory = MyBatisUtils.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		int count = session.selectOne("com.zft.entity.Cart.findCartNumber");
		return count;
	}
	
	/**
	 * 分页查询
	 */
	@Override
	public PageModel<Cart> findCartByPage(Integer userid, Integer pageNo, Integer pageSize) {
		SqlSessionFactory factory = MyBatisUtils.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		List<Cart> carts = new ArrayList<Cart>();
		Map<String, Integer> map = new HashMap<String,Integer>();
		Integer offset = (pageNo-1)*pageSize;
		map.put("userid", userid);
		map.put("pageSize", pageSize);
		map.put("offset", offset);
		carts = session.selectList("com.zft.entity.Cart.findCartByPage", map);
		PageModel<Cart> pageModel = new PageModel<Cart>();
		pageModel.setData(carts);
		int totalCount = findCartNumber();
		int totalPage = (totalCount%pageSize)==0?totalCount/pageSize:(totalCount/pageSize+1);
		pageModel.setTotalPage(totalPage);
		MyBatisUtils.close(session);
		return pageModel;
	}
	
	/**
	 * 移除购物车某个商品
	 */
	@Override
	public int deleteCartByProductId(Integer userid, Integer productid) {
		SqlSessionFactory factory = MyBatisUtils.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		Map<String, Integer> map = new HashMap<String,Integer>();
		map.put("userid", userid);
		map.put("productid", productid);
		
		int count = session.delete("com.zft.entity.Cart.deleteCartByProductId", map);
		session.commit();
		MyBatisUtils.close(session);
		return count;
	}
	
	
	/**
	 * 根据商品ID增加购物车中商品的数量
	 */
	@Override
	public int increaseCartByProductId(Integer userid, Integer productid) {
		SqlSessionFactory factory = MyBatisUtils.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		Map<String, Integer> map = new HashMap<String,Integer>();
		map.put("userid", userid);
		map.put("productid", productid);
		int count = session.update("com.zft.entity.Cart.increaseCartByProductId", map);
		session.commit();
		MyBatisUtils.close(session);
		return count;
	}
	
	
	/**
	 * 减少商品数量
	 */
	@Override
	public int reduceCartByProductId(Integer userid, Integer productid) {
		SqlSessionFactory factory = MyBatisUtils.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		Map<String, Integer> map = new HashMap<String,Integer>();
		map.put("userid", userid);
		map.put("productid", productid);
		int count = session.update("com.zft.entity.Cart.reduceCartByProductId", map);
		session.commit();
		MyBatisUtils.close(session);
		return count;
	}
	
	
	/**
	 */
	@Override
	public int findAllProductNumber(Integer userid) {
		SqlSessionFactory factory = MyBatisUtils.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		int count = session.selectOne("com.zft.entity.Cart.findAllProductNumber", userid);
		MyBatisUtils.close(session);
		return count;
	}

	@Override
	public int checkOrUncheckedProduct(Integer userid, Integer productid, int checked) {
		SqlSessionFactory factory = MyBatisUtils.getSqlSessionFactory();
		SqlSession session = factory.openSession(true);
		Map<String, Integer> map = new HashMap<String,Integer>();
		map.put("userid", userid);
		map.put("productid", productid);
		map.put("checked", checked); 
		int count = session.update("com.zft.entity.Cart.checkOrUncheckedProduct", map);
		MyBatisUtils.close(session);
		return count;
	}
	
	/**
	 * 查询购物车已选中的商品
	 */
	@Override
	public List<Cart> findCartListByUserId(Integer userid) {
		SqlSessionFactory factory = MyBatisUtils.getSqlSessionFactory();
		SqlSession session = factory.openSession(true);
		List<Cart> carts = session.selectList("com.zft.entity.Cart.findCartListByUserId", userid);
		MyBatisUtils.close(session);
		return carts;
	}

	@Override
	public int deleteCheckedProductByUserId(Integer userid) {
		SqlSessionFactory factory = MyBatisUtils.getSqlSessionFactory();
		SqlSession session = factory.openSession(true);
		int result = session.delete("com.zft.entity.Cart.deleteCheckedProductByUserId", userid);
		MyBatisUtils.close(session);
		return result;
	}
	
	

}
