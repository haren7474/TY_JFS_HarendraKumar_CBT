package com.tyss.medicalbookingstore.service;

import java.util.List;

import com.tyss.medicalbookingstore.dto.UserBean;


public interface UserServices 
{
	public List<UserBean> getAllUser();

	public UserBean getUserById(int userId);

	public boolean updateUser(UserBean userBean);

	public boolean deleteUser(int userId);

	public boolean registerUser(UserBean user);

	public UserBean auth(String email, String password);
}
