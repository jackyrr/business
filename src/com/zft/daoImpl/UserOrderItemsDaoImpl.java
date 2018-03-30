package com.zft.daoImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.zft.commom.MyBatisUtils;
import com.zft.dao.UserOrderItemsDao;
import com.zft.entity.UserOrderItems;

/**
 * ¶©µ¥Ã÷Ï¸CRUD	
 * @author Administrator
 *
 */
public class UserOrderItemsDaoImpl implements UserOrderItemsDao{

	@Override
	public int addBatch(List<UserOrderItems> orderItems) {
		SqlSessionFactory factory = MyBatisUtils.getSqlSessionFactory();
		SqlSession session = factory.openSession(true);
		int result = session.insert("com.zft.entity.UserOrderItems.addBatch", orderItems);
		MyBatisUtils.close(session);
		return result;
	}

	@Override
	public List<UserOrderItems> findOrderItemByOrderNo(Integer order_no) {
		// TODO Auto-generated method stub
		return null;
	}

}
