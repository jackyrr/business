package com.zft.serviceImpl;

import java.util.List;

import com.zft.dao.ProductDao;
import com.zft.daoImpl.ProductDaoImpl;
import com.zft.entity.PageModel;
import com.zft.entity.Product;
import com.zft.service.ProductService;

public class ProductServiceImpl implements ProductService{

	ProductDao productDao = new ProductDaoImpl();
	@Override
	public PageModel<Product> findAll(int pageNo, int pageSize) {
		return productDao.findAllByPage(pageNo, pageSize);
	}

	//delete product
	@Override
	public int deleteProduct(int id) {
		return productDao.deleteProduct(id);
	}
	
	//add product
	@Override
	public int addProduct(Product product) {
		return productDao.addProduct(product);
	}

	@Override
	public List<Product> findAll() {
		return productDao.findAll();
	}

	@Override
	public int modifyProduct(Product product) {
		return productDao.modifyProduct(product);
	}

	@Override
	public Product findProduct(int id) {
		return productDao.findProduct(id);
	}

}
