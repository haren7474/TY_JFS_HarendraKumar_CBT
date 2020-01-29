package com.tyss.medicalbookingstore.dao;

import java.util.List;

import com.tyss.medicalbookingstore.dto.OrderBean;

public interface OrderDao {
	public boolean placeOrder(OrderBean orderBean);
	public List<OrderBean> getMyOrders(int userId);
}
