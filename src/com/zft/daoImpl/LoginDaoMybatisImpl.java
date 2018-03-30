package com.zft.daoImpl;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.zft.commom.MyBatisUtils;
import com.zft.dao.LoginDao;
import com.zft.entity.User;

public class LoginDaoMybatisImpl implements LoginDao{

	SqlSessionFactory factory = MyBatisUtils.getSqlSessionFactory();
	SqlSession session = factory.openSession();
	
	@Override
	public int checkUserName(String username) {
		
		Integer count = session.selectOne("com.zft.entity.User.checkUserName", username);
		return count;
	}

	@Override
	public User findUserByUsernameAndPassword(String username, String password) {
		
		Map<String, String> map = new HashMap<String,String>();
		map.put("username", username);
		map.put("password", password);
		User user = session.selectOne("com.zft.entity.User.findUserByUsernameAndPassword", map);
		return user;
	}

	@Override
	public int updateTokenByUserId(Integer userid, String token) {
		
		return 0;
	}

	@Override
	public User findUserByToken(String token) {
		
		return null;
	}

}
