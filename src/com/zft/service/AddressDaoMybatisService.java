package com.zft.service;

import com.zft.entity.Address;
import com.zft.entity.PageModel;

public interface AddressDaoMybatisService {
	
	/**
	 * 分页查询所有的地址
	 * @param pageNo
	 * @param pageSize
	 * @param userid
	 * @return
	 */
	public  PageModel<Address> findUserAddress(Integer pageNo,Integer pageSize,Integer userid);
	
	
	/**
	 * 删除地址
	 * @param userid
	 * @param id
	 * @return
	 */
	public int deleteAddressByUserid(Integer userid,Integer id);
	
	
	/**
	 *添加地址
	 */
	public int addAddress(Integer userid,Address address);
	
	
	/**
	 * 修改地址
	 */
	public int updateAddress(Integer userid,int id,Address address);
	
	/**
	 * 查询某一个地址
	 * @param userid
	 * @param id
	 * @return
	 */
	public Address findOneAddress(Integer userid,int id);
}
