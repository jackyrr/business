package com.zft.daoImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.zft.commom.MyBatisUtils;
import com.zft.dao.UserDao;
import com.zft.entity.PageModel;
import com.zft.entity.User;

public class UserDaoImpl implements UserDao{

	@Override
	public List<User> findAllUser() {
		
		SqlSessionFactory factory = MyBatisUtils.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		List<User> list = session.selectList("com.zft.entity.User.findAllUser");
		MyBatisUtils.close(session);
		return list;
	}

	@Override
	public User findOneUser(Integer user_id) {

		SqlSessionFactory factory = MyBatisUtils.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		User user = session.selectOne("com.zft.entity.User.findOneUser", user_id);
		MyBatisUtils.close(session);
		return user;
	}
	
	
}
