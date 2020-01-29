package com.tyss.medicalbookingstore.dao;

import java.util.List;

import com.tyss.medicalbookingstore.dto.EmailBean;

public interface EmailDao {
	
	public List<EmailBean> getAllEmails();
	public EmailBean getEmailById(int emailUniqueId);
	
	public boolean deleteEmail(int emailUniqueId);
	public boolean sendEmail(EmailBean emailBean);
	public boolean modifyEmail(EmailBean emailBean);
}
