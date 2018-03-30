package com.zft.daoImpl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.zft.commom.DBUtils;
import com.zft.commom.MyBatisUtils;
import com.zft.dao.ProductDao;
import com.zft.entity.PageModel;
import com.zft.entity.Product;

public class ProductDaoImpl implements ProductDao{

	@Override
	public PageModel<Product> findAllByPage(int pageNo, int pageSize) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		PageModel<Product> pageModel = new PageModel<Product>();
		List<Product> list = new ArrayList<Product>();
		Product product = null;
		try {
			conn = DBUtils.getConnection();
			
			//查询总的记录数
			String sql = "select count(id) from product";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				//总记录数
				int totalCount = rs.getInt(1);
				//计算有多少 页
				int totalPage = (totalCount%pageSize)==0?totalCount/pageSize:(totalCount/pageSize+1);
				pageModel.setTotalPage(totalPage);
			}
			
			String sql2 = "select id,category_id,name,subtitle,main_image,sub_images,detail,price,stock,status,create_time,update_time from product limit ?,?";
			ps = conn.prepareStatement(sql2);
			ps.setInt(1, (pageNo-1)*pageSize);
			ps.setInt(2, pageSize);
			rs = ps.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				int category_id = rs.getInt("category_id");
				String name = rs.getString("name");
				String subtitle = rs.getString("subtitle");
				String main_image = rs.getString("main_image");
				String sub_images = rs.getString("sub_images");
				String detail = rs.getString("detail");
				Double _price = rs.getDouble("price");
				BigDecimal price = new BigDecimal(_price);
				int stock = rs.getInt("stock");
				int status = rs.getInt("status");
				Date create_time = rs.getDate("create_time");
				Date update_time = rs.getDate("update_time");
				product = new Product(id, category_id, name, subtitle, main_image, sub_images, detail, price, stock, status, create_time, update_time);
				list.add(product);
			}
			pageModel.setData(list);
			return pageModel;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//根据ID删除商品
	@Override
	public int deleteProduct(int id) {

		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DBUtils.getConnection();
			String sql = "delete from product where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int count = ps.executeUpdate();
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	//add product
	@Override
	public int addProduct(Product product) {
		System.out.println("zft");
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "insert into product(category_id,name,subtitle,main_image,sub_images,detail,price,stock,status,create_time,update_time) values (?,?,?,?,?,?,?,?,?,now(),now())";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, product.getCategory_id());
			ps.setString(2, product.getName());
			ps.setString(3, product.getSubtitle());
			ps.setString(4, product.getMain_image());
			ps.setString(5, product.getSub_images());
			ps.setString(6, product.getDetail());
			ps.setBigDecimal(7, product.getPrice());
			ps.setInt(8, product.getStock());
			ps.setInt(9, product.getStatus());
			int count = ps.executeUpdate();
			System.out.println(count);
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public List<Product> findAll() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Product> list = new ArrayList<Product>();
		Product product = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "select id,category_id,name,subtitle,main_image,sub_images,detail,price,stock,status,create_time,update_time from product";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				int category_id = rs.getInt("category_id");
				String name = rs.getString("name");
				String subtitle = rs.getString("subtitle");
				String main_image = rs.getString("main_image");
				String sub_images = rs.getString("sub_images");
				String detail = rs.getString("detail");
				Double _price = rs.getDouble("price");
				BigDecimal price = new BigDecimal(_price);
				int stock = rs.getInt("stock");
				int status = rs.getInt("status");
				Date create_time = rs.getDate("create_time");
				Date update_time = rs.getDate("update_time");
				product = new Product(id, category_id, name, subtitle, main_image, sub_images, detail, price, stock, status, create_time, update_time);
				list.add(product);
			}
			return list;
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
	
	//update product massage
	@Override
	public int modifyProduct(Product product) {
		System.out.println("**************");
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DBUtils.getConnection();
			String sql = "update product set name=?,subtitle=?,main_image=?,sub_images=?,detail=?,price=?,stock=?,status=? where id =?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, product.getName());
			ps.setString(2, product.getSubtitle());
			ps.setString(3, product.getMain_image());
			ps.setString(4, product.getSub_images());
			ps.setString(5, product.getDetail());
			ps.setBigDecimal(6, product.getPrice());
			ps.setInt(7, product.getStock());
			ps.setInt(8, product.getStatus());
			ps.setInt(9, product.getId());
			int count = ps.executeUpdate();
			System.out.println(count);
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
		
		return 0;
	}
	@Override
	public Product findProduct(int id) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Product product = null;
		try {
			conn = DBUtils.getConnection();
			String sql = "select *from product where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()){
				int _id = rs.getInt("id");
				int _category_id = rs.getInt("category_id");
				String _name = rs.getString("name");
				String _subtitle = rs.getString("subtitle");
				String _main_image = rs.getString("main_image");
				String _sub_images = rs.getString("sub_images");
				String _detail = rs.getString("detail");
				Double _price = rs.getDouble("price");
				BigDecimal price = new BigDecimal(_price);
				int _stock = rs.getInt("stock");
				int _status = rs.getInt("status");
				Date _create_time = rs.getDate("create_time");
				Date _update_time = rs.getDate("update_time");
				product = new Product(_id, _category_id, _name, _subtitle, _main_image, _sub_images, _detail, price, _stock, _status, _create_time, _update_time);
				return product;
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
	public long getProductStock(Integer product_id) {
		SqlSessionFactory factory = MyBatisUtils.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		int result = session.selectOne("com.zft.entity.Product.getProductStock", product_id);
		MyBatisUtils.close(session);
		return result;
	}
	
	@Override
	public int reduceProductStock(Integer product_id, Integer quantity) {
		SqlSessionFactory factory = MyBatisUtils.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		Map<String, Integer> map = new HashMap<String,Integer>();
		map.put("product_id", product_id);
		map.put("quantity", quantity);
		int result = session.update("com.zft.entity.Product.reduceProductStock", map);
		session.commit();
		MyBatisUtils.close(session);
		return result;
	}

}
