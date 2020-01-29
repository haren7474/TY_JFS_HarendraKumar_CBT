package com.tyss.medicalbookingstore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.tyss.medicalbookingstore.dto.ShoppingCartBean;

@Repository
public class ShoppingCartDaoImpl implements ShoppingCartDao {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	private List<ShoppingCartBean> shoppingList = null;
	ShoppingCartBean bean = null;

	@Override
	public List<ShoppingCartBean> viewCart(int userId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from ShoppingCartBean where userId=: userId";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("userId", userId);
		shoppingList = query.getResultList();
		entityManager.close();
		return shoppingList;
	}

	@Override
	public boolean updateCart(ShoppingCartBean shoppingCartBean) {
		return false;
	}

	@Override
	public boolean addToCart(ShoppingCartBean shoppingCartBean) {
		boolean isAdded = false;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(shoppingCartBean);
			transaction.commit();
			isAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		entityManager.close();
		return isAdded;
	}

}
