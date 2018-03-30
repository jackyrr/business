package com.zft.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.zft.commom.DBUtils;
import com.zft.dao.CategoryDao;
import com.zft.entity.Category;
import com.zft.entity.PageModel;
import com.zft.entity.Product;

public class CategoryDaoImpl implements CategoryDao{

	@Override
	public List<Category> findAll() {
		List<Category> list = new ArrayList<Category>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtils.getConnection();
			String sql = "select * from Category";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				int _id = rs.getInt("id");
				int _parent_id = rs.getInt("parent_id");
				String _name = rs.getString("name");
				int _status = rs.getInt("status");
				int _sort_order = rs.getInt("sort_order");
				Date _create_time = rs.getDate("create_time");
				Date _update_time = rs.getDate("update_time");
				Category category = new Category(_id, _parent_id, _name, _status, _sort_order, _create_time, _update_time);
				list.add(category);
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

		return list;
	}

	@Override
	public int deleteCategory(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtils.getConnection();
			String sql = "delete from category where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int result = ps.executeUpdate();
			return result;
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
	public int addCategory(Category category) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "insert into category(parent_id,name,status,sort_order,create_time,update_time) values(?,?,?,?,now(),now())";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, category.getParent_id());
			ps.setString(2, category.getName());
			ps.setInt(3,category.getStatus());
			ps.setInt(4, category.getSort_order());
			int count = ps.executeUpdate();
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	//修改商品类别信息
	@Override
	public int modifyCategory(Category category) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DBUtils.getConnection();
			String sql = "update category set parent_id = ?,name = ?,status = ?,sort_order = ?,update_time = now() where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, category.getParent_id());
			ps.setString(2, category.getName());
			ps.setInt(3, category.getStatus());
			ps.setInt(4, category.getSort_order());
			ps.setInt(5, category.getId());
			int count = ps.executeUpdate();
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				DBUtils.closeConnection(conn, ps);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("update!!!!!");
		return 0;
	}
	//根据ID查询指定的商品类别
	@Override
	public Category findCategory(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtils.getConnection();
			String sql = "select *from category where id =?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()){
				int _id = rs.getInt("id");
				int _parent_id = rs.getInt("parent_id");
				String _name = rs.getString("name");
				int _status = rs.getInt("status");
				int _sort_order = rs.getInt("sort_order");
				Date _create_time = rs.getDate("create_time");
				Date _update_time = rs.getDate("update_time");
				Category category = new Category(_id, _parent_id, _name, _status, _sort_order, _create_time, _update_time);
				return category;
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
		
		return null;
	}

	@Override
	public PageModel<Category> findAllByPage(int pageNo, int pageSize) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		PageModel<Category> pageModel = new PageModel<Category>();
		List<Category> list = new ArrayList<Category>();
		Category category = null;
		try {
			conn = DBUtils.getConnection();
			
			//查询总的记录数
			String sql = "select count(id) from category";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				//总记录数
				int totalCount = rs.getInt(1);
				//计算有多少 页
				int totalPage = (totalCount%pageSize)==0?totalCount/pageSize:(totalCount/pageSize+1);
				pageModel.setTotalPage(totalPage);
			}
			
			String sql2 = "select id,parent_id,name,status,sort_order,create_time,update_time from category limit ?,?";
			ps = conn.prepareStatement(sql2);
			ps.setInt(1, (pageNo-1)*pageSize);
			ps.setInt(2, pageSize);
			rs = ps.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				int parent_id = rs.getInt("parent_id");
				String name = rs.getString("name");
				int status = rs.getInt("status");
				int sort_order = rs.getInt("sort_order");
				Date create_time = rs.getDate("create_time");
				Date update_time = rs.getDate("update_time");
				category = new Category(id, parent_id, name, status, sort_order, create_time, update_time);
				list.add(category);
			}
			pageModel.setData(list);
			return pageModel;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
