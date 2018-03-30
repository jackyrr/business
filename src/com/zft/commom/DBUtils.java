package com.zft.commom;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtils {
	
	private  static Properties ps = new Properties();
	
	static{
		
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("jdbc.properties");
		
		try {
			ps.load(is);
			//加载驱动
			Class.forName(ps.getProperty("driver"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	
	}
	
	//获取连接
	public static Connection getConnection() throws SQLException{
		Connection conn = null;
		conn =DriverManager.getConnection(ps.getProperty("url"), ps.getProperty("userName"), ps.getProperty("password"));
		return conn;
	}
	//关闭连接
	public static  void closeConnection(Connection conn) throws SQLException{
		if(conn!=null){
			
			conn.close();
		}
	}
	public static void closeConnection(Connection conn,Statement stmt) throws SQLException{
		if(stmt!=null){
			
			stmt.close();
		}
		if(conn!=null){
			
			conn.close();
		}
	}
	public static void closeConnection(Connection conn,PreparedStatement ps) throws SQLException{
		if(ps!=null){
			
			ps.close();
		}
		if(conn!=null){
			
			conn.close();
		}
	}
	public static void closeConnection(Connection conn,PreparedStatement ps,ResultSet rs) throws SQLException{
		if(rs!=null){
			
			rs.close();
		}
		if(ps!=null){
			
			ps.close();
		}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
		if(conn!=null){
			
			conn.close();
		}
	}
	
	
	
}
