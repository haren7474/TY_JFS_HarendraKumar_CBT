package com.tyss.medicalbookingstore.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.medicalbookingstore.dto.EmailBean;
import com.tyss.medicalbookingstore.dto.EmailResponse;
import com.tyss.medicalbookingstore.service.EmailServices;

@RestController
//@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmailController {

	@Autowired
	private EmailServices service;

	@PostMapping(path = "/medicalbookingboot/sendEmail", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public EmailResponse sendEmail(@RequestBody EmailBean bean) {
		EmailResponse response = new EmailResponse();

		if (service.sendEmail(bean)) {
			response.setMessage("Success");
			response.setDescription("Email sent successfully");
			response.setStatusCode(201);
			response.setEmailBean(Arrays.asList(bean));

		} else {
			response.setMessage("Failure");
			response.setDescription("Email not sent, try again");
			response.setStatusCode(401);
		}
		return response;
	}

	@PutMapping(path = "/medicalbookingboot/updateEmail", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public EmailResponse updateEmail(@RequestBody EmailBean bean) {
		EmailResponse response = new EmailResponse();

		if (service.modifyEmail(bean)) {
			response.setMessage("Success");
			response.setDescription("Email updated successfully");
			response.setStatusCode(201);
			response.setEmailBean(Arrays.asList(bean));

		} else {
			response.setMessage("Failure");
			response.setDescription("Email not updated, Id not found");
			response.setStatusCode(401);
		}
		return response;
	}

	@DeleteMapping(path = "/medicalbookingboot/deleteEmail/{emailUniqueId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmailResponse deleteEmail(@PathVariable("emailUniqueId") int emailUniqueId) {
		EmailResponse response = new EmailResponse();

		if (service.deleteEmail(emailUniqueId)) {
			response.setMessage("Success");
			response.setDescription("Email deleted successfully");
			response.setStatusCode(201);

		} else {
			response.setMessage("Failure");
			response.setDescription("Email not deleted, try again");
			response.setStatusCode(401);
		}
		return response;
	}

	@PostMapping(path = "/medicalbookingboot/getEmail", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public EmailResponse getEmail(@RequestParam("emailUniqueId") int emailUniqueId) {
		EmailResponse response = new EmailResponse();
		EmailBean bean = service.getEmailById(emailUniqueId);
		if (bean != null) {
			response.setMessage("Success");
			response.setDescription("Email found and sent");
			response.setStatusCode(201);
			response.setEmailBean(Arrays.asList(bean));

		} else {
			response.setMessage("Failure");
			response.setDescription("Email not found");
			response.setStatusCode(401);
		}
		return response;
	}

	@PostMapping(path = "/medicalbookingboot/getAllEmails", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public EmailResponse getAllEmails() {
		EmailResponse response = new EmailResponse();
		List<EmailBean> list = service.getAllEmails();
		if (list.size() > 0) {
			response.setMessage("Success");
			response.setDescription("Email found and sent");
			response.setStatusCode(201);
			response.setEmailBean(list);

		} else {
			response.setMessage("Failure");
			response.setDescription("Empty List");
			response.setStatusCode(401);
		}
		return response;
	}
}
