package com.zft.dao;

import com.zft.entity.Address;
import com.zft.entity.PageModel;

public interface UserAddressDao {
	
	/**
	 * ����û��ջ���ַ
	 * @param userid  �û�ID
	 * @param address  ��ַ����
	 * @return  int
	 */
	public int addAddress(Integer userid,Address address);
	
	
	
	/**
	 * ɾ���û���ַ
	 * @param userid  �û�ID
	 * @param id  ��ַID
	 * @return  int
	 */
	public int deleteAddressByUserid(Integer userid,Integer id);
	
	
	
	/**
	 * �û��޸��ջ���ַ
	 * @param userid
	 * @param address  ��Ҫ�޸ĵ�address
	 * @return
	 */
	public int updateUserAddressByUserid(Integer userid,int id,Address address);
	
	
	/**
	 * ��ѯ�ܼ�¼��
	 * @return
	 */
	public int findAllCount();
	
	
	
	
	/**
	 * ��ҳ��ѯ�û��ջ���ַ
	 * @param pageNo
	 * @param pageSize
	 * @param userid
	 * @return
	 */
	public  PageModel<Address> findUserAddress(Integer pageNo,Integer pageSize,Integer userid);
	
	
	/**
	 * �����û�ID �͵�ַID ��ѯĳһ����ַ
	 * @param userid
	 * @param id
	 * @return
	 */
	public Address findOneAddress(Integer userid,int id);
	
	/**
	 * ����ID���ҵ�ַ
	 * @param id
	 * @return Address
	 */
	public Address findOneAddressById(int id);
}
