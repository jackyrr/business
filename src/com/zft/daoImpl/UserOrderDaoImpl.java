package com.zft.daoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.zft.commom.MyBatisUtils;
import com.zft.dao.UserOrderDao;
import com.zft.entity.PageModel;
import com.zft.entity.UserOrder;
import com.zft.entity.UserOrderItems;

public class UserOrderDaoImpl implements UserOrderDao{
	
	
	/**
	 * ��Ӷ���
	 */
	@Override
	public int addUserOrder(UserOrder userOrder) {
		SqlSessionFactory factory = MyBatisUtils.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		int count = session.insert("com.zft.entity.UserOrder.addUserOrder", userOrder);
		session.commit();
		MyBatisUtils.close(session);
		return count;
	}
	
	
	/**
	 * ��ҳ��ѯ����
	 */
	@Override
	public PageModel<UserOrder> findUserOrderByPage(Integer userid, Integer pageNo, Integer pageSize) {
		SqlSessionFactory factory = MyBatisUtils.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		//��ȡ�ܵļ�¼��
		Integer totalcount = session.selectOne("com.zft.entity.UserOrder.findTotalCount", userid);
		
		//��ҳ��ȡ����
		Map<String, Integer> map = new HashMap<>();
		map.put("user_id", userid);
		map.put("offset", (pageNo-1)*pageSize);
		map.put("pageSize", pageSize);
		
		List<UserOrder> orders = session.selectList("com.zft.entity.UserOrder.findUserOrderByPage", map);
		
		PageModel<UserOrder> pageModel = new PageModel<UserOrder>();
		int totalPage = (totalcount%pageSize==0 ? totalcount/pageSize : totalcount/pageSize+1);
		pageModel.setTotalPage(totalPage);
		pageModel.setData(orders);
		
		return pageModel;
	}
	
	
	/**
	 * �������Ų�ѯ
	 */
	@Override
	public UserOrder findUserOrderDetailByOrderNo(long order_no) {
		SqlSessionFactory factory = MyBatisUtils.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		UserOrder order = session.selectOne("com.zft.entity.UserOrder.findUserOrderDetailByOrderNo", order_no);
		MyBatisUtils.close(session);
		return order;
	}

	@Override
	public int updateOrderStatusByOrderNo(long order_no,Integer status) {
		SqlSessionFactory factory = MyBatisUtils.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		Map<String, Object> map = new HashMap<>();
		map.put("order_no", order_no);
		map.put("status", status);
		int result = session.update("com.zft.entity.UserOrder.updateOrderStatusByOrderNo", map);
		session.commit();
		MyBatisUtils.close(session);
		return result;
	}

	/**
	 * ͨ�������Ż�ȡ��������
	 */
	@Override
	public List<UserOrderItems> findAllUserOrderItems(long order_no) {
		SqlSessionFactory factory = MyBatisUtils.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		List<UserOrderItems> list = session.selectList("com.zft.entity.UserOrder.findAllUserOrderItems", order_no);
		MyBatisUtils.close(session);
		return list;
	}

}
