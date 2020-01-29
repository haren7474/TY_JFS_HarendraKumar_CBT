package com.tyss.medicalbookingstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.medicalbookingstore.dao.OrderDao;
import com.tyss.medicalbookingstore.dto.OrderBean;
import com.tyss.medicalbookingstore.dto.ShoppingCartBean;

@Service
public class OrderServicesImpl implements OrderServices {

	@Autowired
	OrderDao orderDao;

	@Override
	public boolean placeOrder(OrderBean orderBean) {
//		ShoppingCartServices shoppingCartServices;
		// List<ShoppingCartBean> list = shoppingCartServices.viewCart(2);
		// orderBean.setUserBean(userBean);
		// orderBean.setOrderId(orderBean.getOrderPlacingTimestamp() + "_" +
		// orderBean.getUserBean().getUserId());
//		orderBean.setOrderStatus("Initiated");

		return orderDao.placeOrder(orderBean);
	}

	@Override
	public List<OrderBean> getMyOrders(int userId) {
		return orderDao.getMyOrders(userId);
	}
}
