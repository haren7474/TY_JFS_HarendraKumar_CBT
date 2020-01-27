package com.tyss.medicalbookingstore.service;

import java.util.List;

import com.tyss.medicalbookingstore.dto.EmailBean;


public interface EmailServices 
{
	public List<EmailBean> getAllEmails();
	public EmailBean getEmailById(int emailUniqueId);
	
	public boolean deleteEmail(int emailUniqueId);
	public boolean sendEmail(EmailBean emailBean);
	public boolean modifyEmail(EmailBean emailBean);
	
}
