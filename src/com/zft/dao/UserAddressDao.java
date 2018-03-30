package com.zft.dao;

import com.zft.entity.Address;
import com.zft.entity.PageModel;

public interface UserAddressDao {
	
	/**
	 * 添加用户收货地址
	 * @param userid  用户ID
	 * @param address  地址对象
	 * @return  int
	 */
	public int addAddress(Integer userid,Address address);
	
	
	
	/**
	 * 删除用户地址
	 * @param userid  用户ID
	 * @param id  地址ID
	 * @return  int
	 */
	public int deleteAddressByUserid(Integer userid,Integer id);
	
	
	
	/**
	 * 用户修改收货地址
	 * @param userid
	 * @param address  需要修改的address
	 * @return
	 */
	public int updateUserAddressByUserid(Integer userid,int id,Address address);
	
	
	/**
	 * 查询总记录数
	 * @return
	 */
	public int findAllCount();
	
	
	
	
	/**
	 * 分页查询用户收货地址
	 * @param pageNo
	 * @param pageSize
	 * @param userid
	 * @return
	 */
	public  PageModel<Address> findUserAddress(Integer pageNo,Integer pageSize,Integer userid);
	
	
	/**
	 * 根据用户ID 和地址ID 查询某一个地址
	 * @param userid
	 * @param id
	 * @return
	 */
	public Address findOneAddress(Integer userid,int id);
	
	/**
	 * 根据ID查找地址
	 * @param id
	 * @return Address
	 */
	public Address findOneAddressById(int id);
}
