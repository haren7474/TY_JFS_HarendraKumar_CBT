package com.tyss.medicalbookingstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.medicalbookingstore.dao.UserDao;
import com.tyss.medicalbookingstore.dto.UserBean;
import com.tyss.medicalbookingstore.exception.UserException;

@Service
public class UserServicesImpl implements UserServices {

	@Autowired
	private UserDao dao;

	@Override
	public List<UserBean> getAllUser() {
		return dao.getAllUser();
	}

	@Override
	public UserBean getUserById(int userId) {
		return dao.getUserById(userId);
	}

	@Override
	public boolean updateUser(UserBean userBean) {
		return dao.updateUser(userBean);
	}

	@Override
	public boolean deleteUser(int userId) {
		return dao.deleteUser(userId);
	}

	@Override
	public boolean registerUser(UserBean user) {
		return dao.registerUser(user);
	}

	@Override
	public UserBean auth(String email, String password) {
		System.out.println("---------service called for auth method");
		UserBean bean = dao.auth(email);
		System.out.println("---------user receieved in service");
		if (bean != null) {
			if (bean.getPassword().equals(password)) {
				return bean;
			}
			throw new UserException("Password not matching");
		} else {
			throw new UserException("Email does not exist");
		}
	}
}
