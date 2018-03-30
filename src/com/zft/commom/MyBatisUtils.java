package com.zft.commom;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * MyBatisπ§æﬂ¿‡
 * @author Administrator
 *
 */
public class MyBatisUtils {
	
	public static SqlSessionFactory sqlSessionFactory = null;
	
	
	/**
	 * get  SqlSessionFactory
	 * @return
	 */
	public static SqlSessionFactory getSqlSessionFactory(){
		String resource = "com/zft/config/MyBatisConfig.xml";
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sqlSessionFactory;
	}
	
	
	/**
	 * close SqlSession
	 */
	public static void close(SqlSession session){
		session.close();
	}
}
