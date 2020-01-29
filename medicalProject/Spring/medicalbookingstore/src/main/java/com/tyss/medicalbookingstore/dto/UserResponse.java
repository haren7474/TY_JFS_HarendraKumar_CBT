package com.tyss.medicalbookingstore.dto;

import java.util.List;

import lombok.Data;

@Data
public class UserResponse {
	private int statusCode;
	private String message;
	private String description;
	private List<UserBean> userBean;
}
