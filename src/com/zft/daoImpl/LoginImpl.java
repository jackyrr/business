package com.zft.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zft.commom.DBUtils;
import com.zft.dao.LoginDao;
import com.zft.entity.User;

public class LoginImpl implements LoginDao{

	@Override
	public int checkUserName(String username) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "select username from user where username=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if(rs.next()){
				return 1;
			}else{
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				DBUtils.closeConnection(conn, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public User findUserByUsernameAndPassword(String username, String password) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtils.getConnection();
			String sql = "select id,username,password,role from user where username=? and password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if(rs.next()){
				int _id = rs.getInt("id");
				String _username = rs.getString("username");
				String _password = rs.getString("password");
				int _role = rs.getInt("role");
				User user = new User();
				user.setId(_id);
				user.setUsername(_username);
				user.setPassword(_password);
				user.setRole(_role);
				return user;
			}else{
				return null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				DBUtils.closeConnection(conn, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	//update user token
	@Override
	public int updateTokenByUserId(Integer userid, String token) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DBUtils.getConnection();
			String sql = "update user set token=? where id =?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, token);
			ps.setInt(2, userid);
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				DBUtils.closeConnection(conn, ps);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public User findUserByToken(String token) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtils.getConnection();
			String sql = "select id,username,password from user where token=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, token);
			rs = ps.executeQuery();
			if(rs.next()){
				int _id = rs.getInt("id");
				String _username = rs.getString("username");
				String _password = rs.getString("password");
				User user = new User();
				user.setId(_id);
				user.setUsername(_username);
				user.setPassword(_password);
				return user;
			}else{
				return null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				DBUtils.closeConnection(conn, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
}
