package com.tyss.medicalbookingstore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.tyss.medicalbookingstore.dto.UserBean;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	private List<UserBean> userList = null;
	UserBean user = null;

	@Override
	public List<UserBean> getAllUser() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = " from UserBean";
		Query query = entityManager.createQuery(jpql);
		userList = query.getResultList();
		entityManager.close();
		return userList;
	}

	@Override
	public UserBean getUserById(int userId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		user = entityManager.find(UserBean.class, userId);
		if (user != null) {
			return user;
		} else {
			return null;
		}
	}

	@Override
	public boolean updateUser(UserBean userBean) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		boolean isModified = false;
		try {
			transaction.begin();
			user = entityManager.find(UserBean.class, userBean.getUserId());
			if (user != null) {
				if ((!(user.getUserImageUrl().equalsIgnoreCase(userBean.getUserImageUrl())))
						&& userBean.getUserImageUrl() != null) {
					user.setUserImageUrl(userBean.getUserImageUrl());
				}

				if ((!(user.getUserName().equalsIgnoreCase(userBean.getUserName())))
						&& userBean.getUserName() != null) {
					user.setUserName(userBean.getUserName());
				}

				if ((!(user.getStreetAdd1().equalsIgnoreCase(userBean.getStreetAdd1())))
						&& userBean.getStreetAdd1() != null) {
					user.setStreetAdd1(userBean.getStreetAdd1());
				}

				if ((!(user.getPostalCode() == userBean.getPostalCode())) && userBean.getPostalCode() != 0) {
					user.setPostalCode(userBean.getPostalCode());
				}

				if ((!(user.getTown().equalsIgnoreCase(userBean.getTown()))) && userBean.getTown() != null) {
					user.setTown(userBean.getTown());
				}

				if ((!(user.getEmail().equalsIgnoreCase(userBean.getEmail()))) && userBean.getEmail() != null) {
					user.setEmail(userBean.getEmail());
				}

				if ((!(user.getMobileNumber().equalsIgnoreCase(userBean.getMobileNumber())))
						&& userBean.getMobileNumber() != null) {
					user.setMobileNumber(userBean.getMobileNumber());
				}

				if ((!(user.getPassword().equalsIgnoreCase(userBean.getPassword())))
						&& userBean.getPassword() != null) {
					user.setPassword(userBean.getPassword());
				}

				transaction.commit();
				isModified = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		entityManager.close();
		return isModified;
	}

	@Override
	public boolean deleteUser(int userId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		boolean isDeleted = false;
		try {
			transaction.begin();
			user = entityManager.find(UserBean.class, userId);
			if (user != null) {
				entityManager.remove(user);
				transaction.commit();
				isDeleted = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		entityManager.close();
		return isDeleted;
	}

	@Override
	public boolean registerUser(UserBean user) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		boolean isAdded = false;
		try {
			transaction.begin();
			entityManager.persist(user);
			transaction.commit();
			isAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		entityManager.close();
		return isAdded;
	}

	@Override
	public UserBean auth(String email) {
		System.out.println("---------call came to dao auth ");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String jpql = "from UserBean where email=:email";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("email", email);
		UserBean bean = null;
		try {
			bean = (UserBean) query.getSingleResult();
			System.out.println("bean recieved from db");
			System.out.println(bean.getEmail());
			System.out.println(bean.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		return bean;
	}

}
