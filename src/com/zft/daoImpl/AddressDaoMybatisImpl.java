package com.zft.daoImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.zft.commom.MyBatisUtils;
import com.zft.dao.UserAddressDao;
import com.zft.entity.Address;
import com.zft.entity.Cart;
import com.zft.entity.PageModel;

public class AddressDaoMybatisImpl implements UserAddressDao{

	SqlSessionFactory factory = MyBatisUtils.getSqlSessionFactory();
	@Override
	public int addAddress(Integer userid, Address address) {
		SqlSession session = factory.openSession();
		
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("userid", userid);
		map.put("address", address);
		
		int count = session.insert("com.zft.entity.Address.addAddress", map);
		session.commit();
		MyBatisUtils.close(session);
		return count;
	}

	@Override
	public int deleteAddressByUserid(Integer userid, Integer id) {
		SqlSession session = factory.openSession();
		
		Map<String, Integer> map = new HashMap<String,Integer>();
		map.put("userid", userid);
		map.put("id", id);
		
		int count = session.delete("com.zft.entity.Address.deleteAddressByUserid", map);
		session.commit();
		MyBatisUtils.close(session);
		return count;
	}

	@Override
	public int updateUserAddressByUserid(Integer userid,int id, Address address) {
		SqlSession session = factory.openSession();
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("userid", userid);
		map.put("address", address);
		map.put("id", id);
		int count = session.update("com.zft.entity.Address.updateUserAddressByUserid", map);
		session.commit();
		MyBatisUtils.close(session);
		return count;
	}
	/**
	 * 分页查询所有地址
	 */
	@Override
	public PageModel<Address> findUserAddress(Integer pageNo, Integer pageSize, Integer userid) {
		SqlSession session = factory.openSession();
		List<Address> addresses = new ArrayList<Address>();
		Map<String, Integer> map = new HashMap<String,Integer>();
		Integer offset = (pageNo-1)*pageSize;
		map.put("userid", userid);
		map.put("pageSize", pageSize);
		map.put("offset", offset);
		addresses = session.selectList("com.zft.entity.Address.findUserAddress", map);
		PageModel<Address> pageModel = new PageModel<Address>();
		pageModel.setData(addresses);
		int totalCount = findAllCount();
		int totalPage = (totalCount%pageSize)==0?totalCount/pageSize:(totalCount/pageSize+1);
		pageModel.setTotalPage(totalPage);
		MyBatisUtils.close(session);
		return pageModel;
	}
	
	/**
	 * 查询总的记录数
	 */
	@Override
	public int findAllCount() {
		
		SqlSession session = factory.openSession();
		int count = session.selectOne("com.zft.entity.Address.findAllCount");
		MyBatisUtils.close(session);
		return count;
	}
	
	
	
	/**
	 * 查询某个地址
	 */
	@Override
	public Address findOneAddress(Integer userid, int id) {
		SqlSession session = factory.openSession();
		Map<String, Integer> map = new HashMap<String,Integer>();
		map.put("userid", userid);
		map.put("id", id);
		Address address = session.selectOne("com.zft.entity.Address.findOneAddress", map);
		MyBatisUtils.close(session);
		return address;
	}

	@Override
	public Address findOneAddressById(int id) {
		SqlSession session = factory.openSession();
		Address address = session.selectOne("com.zft.entity.Address.findOneAddressById", id);
		MyBatisUtils.close(session);
		return address; 
	}

}
