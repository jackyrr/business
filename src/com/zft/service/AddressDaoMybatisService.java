package com.zft.service;

import com.zft.entity.Address;
import com.zft.entity.PageModel;

public interface AddressDaoMybatisService {
	
	/**
	 * ��ҳ��ѯ���еĵ�ַ
	 * @param pageNo
	 * @param pageSize
	 * @param userid
	 * @return
	 */
	public  PageModel<Address> findUserAddress(Integer pageNo,Integer pageSize,Integer userid);
	
	
	/**
	 * ɾ����ַ
	 * @param userid
	 * @param id
	 * @return
	 */
	public int deleteAddressByUserid(Integer userid,Integer id);
	
	
	/**
	 *��ӵ�ַ
	 */
	public int addAddress(Integer userid,Address address);
	
	
	/**
	 * �޸ĵ�ַ
	 */
	public int updateAddress(Integer userid,int id,Address address);
	
	/**
	 * ��ѯĳһ����ַ
	 * @param userid
	 * @param id
	 * @return
	 */
	public Address findOneAddress(Integer userid,int id);
}
