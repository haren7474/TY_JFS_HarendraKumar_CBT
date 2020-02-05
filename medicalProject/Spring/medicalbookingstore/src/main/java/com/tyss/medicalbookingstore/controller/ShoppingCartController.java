package com.tyss.medicalbookingstore.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.medicalbookingstore.dto.ShoppingCartBean;
import com.tyss.medicalbookingstore.dto.ShoppingCartResponse;
import com.tyss.medicalbookingstore.service.ShoppingCartServices;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ShoppingCartController {

	@Autowired
	private ShoppingCartServices service;

	@PostMapping(path = "/medicalbookingboot/addToCart", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ShoppingCartResponse addToCart(@RequestBody ShoppingCartBean bean) {
		ShoppingCartResponse response = new ShoppingCartResponse();

		if (service.addToCart(bean)) {
			response.setMessage("Success");
			response.setDescription("Product added to Cart!!!");
			response.setStatusCode(201);
			response.setShoppingList(Arrays.asList(bean));

		} else {
			response.setMessage("Failure");
			response.setDescription("Product not added to cart, try again");
			response.setStatusCode(401);
		}
		return response;
	}

	@PutMapping(path = "/medicalbookingboot/updateCart", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ShoppingCartResponse updateCart(@RequestBody ShoppingCartBean bean) {
		ShoppingCartResponse response = new ShoppingCartResponse();

		if (service.updateCart(bean)) {
			response.setMessage("Success");
			response.setDescription("Cart updated successfully");
			response.setStatusCode(201);
			response.setShoppingList(Arrays.asList(bean));

		} else {
			response.setMessage("Failure");
			response.setDescription("Cart not updated, Try Again");
			response.setStatusCode(401);
		}
		return response;
	}

	@GetMapping(path = "/medicalbookingboot/viewCart/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ShoppingCartResponse viewCart(@PathVariable("userId") int userId) {
		ShoppingCartResponse response = new ShoppingCartResponse();
		List<ShoppingCartBean> list = service.viewCart(userId);
		if (list.size() > 0) {
			response.setMessage("Success");
			response.setDescription("Cart found and sent");
			response.setStatusCode(201);
			response.setShoppingList(list);

		} else {
			response.setMessage("Failure");
			response.setDescription("Empty List");
			response.setStatusCode(401);
		}
		return response;
	}
}
