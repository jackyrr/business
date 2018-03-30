package com.zft.serviceImpl;

import com.zft.dao.UserAddressDao;
import com.zft.daoImpl.AddressDaoMybatisImpl;
import com.zft.entity.Address;
import com.zft.entity.PageModel;
import com.zft.service.AddressDaoMybatisService;

public class AddressDaoMybatisServiceImpl implements AddressDaoMybatisService{
	
	UserAddressDao addressDao = new AddressDaoMybatisImpl(); 
	
	
	@Override
	public PageModel<Address> findUserAddress(Integer pageNo, Integer pageSize, Integer userid) {
		
		return addressDao.findUserAddress(pageNo, pageSize, userid);
	}


	@Override
	public int deleteAddressByUserid(Integer userid, Integer id) {
		return addressDao.deleteAddressByUserid(userid, id);
	}

		
	@Override
	public int addAddress(Integer userid, Address address) {
		
		return addressDao.addAddress(userid, address);
	}

	@Override
	public Address findOneAddress(Integer userid, int id) {
		return addressDao.findOneAddress(userid, id);
	}


	@Override
	public int updateAddress(Integer userid, int id, Address address) {
		
			
		return addressDao.updateUserAddressByUserid(userid,id,address);
	}

}
