package com.tyss.medicalbookingstore.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.medicalbookingstore.dto.UserBean;
import com.tyss.medicalbookingstore.dto.UserResponse;
import com.tyss.medicalbookingstore.service.UserServices;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

	@Autowired
	private UserServices userServices;

	@PostMapping(path = "/medicalbookingboot/addUser", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse addUser(@RequestBody UserBean userBean) {
		UserResponse response = new UserResponse();

		if (userServices.registerUser(userBean)) {
			response.setMessage("Success");
			response.setDescription("User added successfully");
			response.setStatusCode(201);
			response.setUserBean((Arrays.asList(userBean)));

		} else {
			response.setMessage("Failure");
			response.setDescription("User not added, Email already exists");
			response.setStatusCode(401);
		}
		return response;
	}

	@PutMapping(path = "/medicalbookingboot/updateUser", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse updateUser(@RequestBody UserBean bean) {
		UserResponse response = new UserResponse();

		if (userServices.updateUser(bean)) {
			response.setMessage("Success");
			response.setDescription("User updated successfully");
			response.setStatusCode(201);
			response.setUserBean((Arrays.asList(bean)));

		} else {
			response.setMessage("Failure");
			response.setDescription("User not updated, Id not found");
			response.setStatusCode(401);
		}
		return response;
	}

	@DeleteMapping(path = "/medicalbookingboot/deleteUser/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse deleteUser(@PathVariable("userId") int userId) {
		UserResponse response = new UserResponse();

		if (userServices.deleteUser(userId)) {
			response.setMessage("Success");
			response.setDescription("User deleted successfully");
			response.setStatusCode(201);
		} else {
			response.setMessage("Failure");
			response.setDescription("Could not be deleted as you are not a customer");
			response.setStatusCode(401);
		}
		return response;

	}

	@GetMapping(path = "/medicalbookingboot/getUser/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse getUser(@PathVariable("userId") int userId) {
		UserResponse response = new UserResponse();
		UserBean bean = userServices.getUserById(userId);
		if (bean != null) {
			response.setMessage("Success");
			response.setDescription("User found and sent");
			response.setStatusCode(201);
			response.setUserBean(Arrays.asList(bean));
		} else {
			response.setMessage("Failure");
			response.setDescription("User not found");
			response.setStatusCode(401);
		}
		return response;
	}

	@PostMapping(path = "/medicalbookingboot/getAllUsers", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse getAllUsers() {
		UserResponse response = new UserResponse();
		List<UserBean> list = userServices.getAllUser();
		if (list.size() > 0) {
			response.setMessage("Success");
			response.setDescription("Users found and sent");
			response.setStatusCode(201);
			response.setUserBean(list);
			System.out.println("inside getAllUsers() : " + list.get(0).getUserName());

		} else {
			response.setMessage("Failure");
			response.setDescription("Empty List");
			response.setStatusCode(401);
		}
		return response;
	}

	@PostMapping(path = "/medicalbookingboot/auth", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse auth(@RequestBody UserBean bean) {
		UserBean userBean = userServices.auth(bean.getEmail(), bean.getPassword());
		UserResponse response = new UserResponse();
		if (userBean != null) {
			response.setStatusCode(201);
			response.setDescription("User found for given credentials");
			response.setMessage("success");
			response.setUserBean(Arrays.asList(userBean));
		} else {
			response.setStatusCode(401);
			response.setDescription("Invalid credentials");
			response.setMessage("failure");
		}
		return response;
	}

}
