package com.tyss.medicalbookingstore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.tyss.medicalbookingstore.dto.ProductBean;
import com.tyss.medicalbookingstore.dto.UserBean;

@Repository
public class ProductDaoImpl implements ProductDao {
	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;

	private List<ProductBean> productList = null;
	ProductBean product = null;

	@Override
	public List<ProductBean> getAllProduct() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from ProductBean";
		Query query = entityManager.createQuery(jpql);
		productList = query.getResultList();
		entityManager.close();
		return productList;
	}

	@Override
	public boolean deleteProduct(int productId) {
		boolean isDeleted = false;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		product = entityManager.find(ProductBean.class, productId);
		if (product != null) {
			entityManager.remove(product);
			isDeleted = true;
		}
		transaction.commit();
		entityManager.close();
		return isDeleted;
	}

	@Override
	public boolean addProduct(ProductBean product) {
		boolean isAdded = false;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(product);
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
	public boolean modifyProduct(ProductBean productBean) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		boolean isModified = false;
		try {
			transaction.begin();
			product = entityManager.find(ProductBean.class, productBean.getProductId());
			if (product != null) {

				if ((!(product.getProductName().equalsIgnoreCase(productBean.getProductName())))
						&& productBean.getProductName() != null) {
					product.setProductName(productBean.getProductName());
				}

				if ((!(product.getProductImageUrl().equalsIgnoreCase(productBean.getProductImageUrl())))
						&& productBean.getProductImageUrl() != null) {
					product.setProductImageUrl(productBean.getProductImageUrl());
				}

				if ((!(product.getProductPrice() == productBean.getProductPrice()))
						&& productBean.getProductPrice() != 0) {
					product.setProductPrice(productBean.getProductPrice());
				}

				if ((!(product.getProductQuantity() == productBean.getProductQuantity()))
						&& productBean.getProductQuantity() != 0) {
					product.setProductQuantity(productBean.getProductQuantity());
				}

				if ((!(product.getProductComments().equalsIgnoreCase(productBean.getProductComments())))
						&& productBean.getProductComments() != null) {
					product.setProductComments(productBean.getProductComments());
				}

				if (productBean.getUserBean() !=null && (!(product.getUserBean().getUserId() == productBean.getUserBean().getUserId()))) {
					UserBean userBean = new UserBean();
					userBean.setUserId(productBean.getUserBean().getUserId());
					product.setUserBean(userBean);
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
	public ProductBean getProductById(int productId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		product = entityManager.find(ProductBean.class, productId);
		if (product != null) {
			return product;
		} else {
			return null;
		}
	}
}
