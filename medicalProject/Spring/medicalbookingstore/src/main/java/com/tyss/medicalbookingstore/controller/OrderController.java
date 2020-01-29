package com.tyss.medicalbookingstore.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.medicalbookingstore.dto.OrderBean;
import com.tyss.medicalbookingstore.dto.OrderResponse;
import com.tyss.medicalbookingstore.dto.ProductBean;
import com.tyss.medicalbookingstore.dto.ProductResponse;
import com.tyss.medicalbookingstore.service.OrderServices;
import com.tyss.medicalbookingstore.service.ProductServices;

@RestController
//@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrderController {

	@Autowired
	private OrderServices service;

	@PostMapping(path = "/medicalbookingboot/placeOrder", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public OrderResponse placeOrder(@RequestBody OrderBean bean) {
		OrderResponse response = new OrderResponse();

		if (service.placeOrder(bean)) {
			response.setMessage("Success");
			response.setDescription("Product added successfully");
			response.setStatusCode(201);
			response.setOrderBean(Arrays.asList(bean));

		} else {
			response.setMessage("Failure");
			response.setDescription("Order not placed, try again");
			response.setStatusCode(401);
		}
		return response;
	}

}
