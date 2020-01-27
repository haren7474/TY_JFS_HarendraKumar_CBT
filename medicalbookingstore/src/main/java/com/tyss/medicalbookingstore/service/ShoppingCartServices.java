package com.tyss.medicalbookingstore.service;

import java.util.List;

import com.tyss.medicalbookingstore.dto.ShoppingCartBean;

public interface ShoppingCartServices {
	
	public List<ShoppingCartBean> viewCart(int userId);
	public boolean updateCart(ShoppingCartBean shoppingCartBean);
	public boolean addToCart(ShoppingCartBean shoppingCartBean);
}
