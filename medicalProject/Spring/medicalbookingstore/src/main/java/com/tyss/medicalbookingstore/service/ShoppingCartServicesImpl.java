package com.tyss.medicalbookingstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.medicalbookingstore.dao.ShoppingCartDao;
import com.tyss.medicalbookingstore.dto.ShoppingCartBean;

@Service
public class ShoppingCartServicesImpl implements ShoppingCartServices {

	@Autowired
	ShoppingCartDao shoppingCartDao;
	
	@Override
	public List<ShoppingCartBean> viewCart(int userId) {
		return shoppingCartDao.viewCart(userId);
	}

	@Override
	public boolean updateCart(ShoppingCartBean shoppingCartBean) {
		return shoppingCartDao.updateCart(shoppingCartBean);
	}

	@Override
	public boolean addToCart(ShoppingCartBean shoppingCartBean) {
		return shoppingCartDao.addToCart(shoppingCartBean);
	}

}
