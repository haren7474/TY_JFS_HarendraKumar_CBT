package com.tyss.medicalbookingstore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.tyss.medicalbookingstore.dto.EmailBean;

@Repository
public class EmailDaoImpl implements EmailDao {
	
	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;

	private List<EmailBean> emailList = null;
	EmailBean email = null;

	@Override
	public List<EmailBean> getAllEmails() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from EmailBean";
		Query query = entityManager.createQuery(jpql);
		emailList = query.getResultList();
		entityManager.close();
		return emailList;
	}

	@Override
	public EmailBean getEmailById(int emailUniqueId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		email = entityManager.find(EmailBean.class, emailUniqueId);
		if (email != null) {
			return email;
		} else {
			return null;
		}
	}

	@Override
	public boolean deleteEmail(int emailUniqueId) {
		boolean isDeleted = false;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		email = entityManager.find(EmailBean.class, emailUniqueId);
		if (email != null) {
			entityManager.remove(email);
			isDeleted = true;
		}
		transaction.commit();
		entityManager.close();
		return isDeleted;
	}

	@Override
	public boolean sendEmail(EmailBean emailBean) {
		boolean isAdded = false;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(emailBean);
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
	public boolean modifyEmail(EmailBean emailBean) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		boolean isModified = false;
		try {
			transaction.begin();
			EmailBean email = entityManager.find(EmailBean.class, emailBean.getEmailUniqueId());
			if (emailBean != null) {

				if (emailBean.getEmailBody() != null
						&& (!(emailBean.getEmailBody().equalsIgnoreCase(email.getEmailBody())))) {
					email.setEmailBody(emailBean.getEmailBody());
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

}
