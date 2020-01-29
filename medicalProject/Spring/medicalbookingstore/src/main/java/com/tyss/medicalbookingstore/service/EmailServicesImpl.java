package com.tyss.medicalbookingstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.medicalbookingstore.dao.EmailDao;
import com.tyss.medicalbookingstore.dto.EmailBean;

@Service
public class EmailServicesImpl implements EmailServices
{
	@Autowired
	private EmailDao emailDao;
	
	@Override
	public List<EmailBean> getAllEmails() 
	{
		return emailDao.getAllEmails();
	}

	@Override
	public boolean deleteEmail(int emailUniqueId) {
		return emailDao.deleteEmail(emailUniqueId);
	}

	@Override
	public boolean sendEmail(EmailBean emailBean) {
		return emailDao.sendEmail(emailBean);
	}

	@Override
	public boolean modifyEmail(EmailBean emailBean) 
	{
		return emailDao.modifyEmail(emailBean);
	}

	@Override
	public EmailBean getEmailById(int emailUniqueId) {
		return emailDao.getEmailById(emailUniqueId);
	}
}
