package com.zft.serviceImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.zft.dao.CartDao;
import com.zft.daoImpl.CartDaoMybatisImpl;
import com.zft.entity.Cart;
import com.zft.entity.PageModel;
import com.zft.entity.vo.CartCheckedVo;
import com.zft.service.CartDaoMybatisService;

public class CartDaoMybatisServiceImpl implements CartDaoMybatisService{

	CartDao cartDao = new CartDaoMybatisImpl();
	@Override
	public int addProductToCart(Integer userid, Integer productid, int quantity) {
		
		
		
		//��userid �� productid ���зǿ��ж�  ���Ϊ�����׳��쳣
		if(userid!=null&&productid!=null){
			
			//����userid ��productid ȥ���ﳵ��ѯ����Ʒ�Ƿ��Ѿ����빺�ﳵ
			Cart cart = cartDao.findCartByUserIdAndProductId(userid, productid);
			if(cart==null){
				
				//������ﳵ�в����ڸ���Ʒ  �򽫸���Ʒ��ӵ����ﳵ
				int count = cartDao.addProductIntoCartByUserIdAndProductId(userid, productid, quantity);
				return count;
			}else{
				
				//������ﳵ�д��ڸ���Ʒ   ����¸���Ʒ�ڹ��ﳵ�е�����
				int count = cartDao.updateCartByUserIdAndProductId(userid, productid, quantity);
				return count;
			}
		}else{
			
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public PageModel<Cart> findCartByPage(Integer userid, Integer pageNo, Integer pageSize) {
		return cartDao.findCartByPage(userid, pageNo, pageSize);
	}
	
	/**
	 * �Ƴ����ﳵ��ĳ����Ʒ
	 */
	@Override
	public PageModel<Cart> deleteCartByProductId(Integer userid, Integer productid) {
		 cartDao.deleteCartByProductId(userid, productid);
		 
		 return findCartByPage(userid,1,3);
	}
	
	
	//������Ʒ����

	@Override
	public int increaseCartByProductId(Integer userid, Integer productid) {
		return cartDao.increaseCartByProductId(userid, productid);
	}
	
	//������Ʒ����
	@Override
	public int reduceCartByProductId(Integer userid, Integer productid) {
		return cartDao.reduceCartByProductId(userid, productid);
	}

	@Override
	public int checkOrUncheckedProduct(Integer userid,int productid,int checked) {
		
		
		
		
		
		return cartDao.checkOrUncheckedProduct(userid, productid, checked);
	/*	CartCheckedVo cartCheckedVo = new CartCheckedVo();
		
		String _product_id = request.getParameter("product_id");
		//product_id �Ǳȴ��ݵ�����
		Integer product_id = null;
		if(_product_id !=null && !(_product_id.equals(""))){
			try{
				product_id = Integer.parseInt(_product_id);
			}catch(NumberFormatException e){
				cartCheckedVo.setErrno(CartCheckedVo.ERRNO_FAIL);
				e.printStackTrace();
				try {
					throw new Exception("ȫѡ��ȡ��ȫѡ����product_id����");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
		//checked
		String _checked = request.getParameter("checked");
		Integer checked = null;
		if(_checked !=null && !(_checked.equals(""))){
			try{
				
				checked = Integer.parseInt(_checked);
			}catch(NumberFormatException e){
				cartCheckedVo.setErrno(CartCheckedVo.ERRNO_FAIL);
				e.printStackTrace();
				try {
					throw new Exception("ȫѡ��ȡ��ȫѡ����checked����");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
		
		int count = cartDao.checkOrUncheckedProduct(userid, product_id, checked);
		if(count>0){
			//succ  ��product_id �� checked��װ��CartCheckedVO
			cartCheckedVo.setErrno(CartCheckedVo.ERRNO_SUCC);
			cartCheckedVo.setProduct_id(product_id);
			cartCheckedVo.setChecked(checked);
		}else{
			
			//fail
		}
		return cartCheckedVo;*/
	}

	@Override
	public int findAllProductNumber(Integer userid) {
		
		return cartDao.findAllProductNumber(userid);
	}
	
	
	
}
