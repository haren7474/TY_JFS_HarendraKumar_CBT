package com.tyss.medicalbookingstore.dao;

import java.util.List;

import com.tyss.medicalbookingstore.dto.EmailBean;
import com.tyss.medicalbookingstore.dto.ShoppingCartBean;

public interface ShoppingCartDao {
	
	public List<ShoppingCartBean> viewCart(int userId);
	public boolean updateCart(ShoppingCartBean shoppingCartBean);
	public boolean addToCart(ShoppingCartBean shoppingCartBean);
}
