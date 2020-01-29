package com.tyss.medicalbookingstore.service;

import java.util.List;

import com.tyss.medicalbookingstore.dto.OrderBean;

public interface OrderServices {
	public boolean placeOrder(OrderBean orderBean);
	public List<OrderBean> getMyOrders(int userId);
}
