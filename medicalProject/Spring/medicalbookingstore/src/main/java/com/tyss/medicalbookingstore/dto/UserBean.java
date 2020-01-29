package com.tyss.medicalbookingstore.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
@SequenceGenerator(name = "user_seq", initialValue = 1, allocationSize = 499)
public class UserBean {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
	private int userId;

	@Column(nullable = false)
	private String userType;

	@Column(nullable = false)
	private String userName;

	@Column(nullable = false)
	private String streetAdd1;

	@Column
	private String streetAdd2;

	@Column(nullable = false)
	private String town;

	@Column(nullable = false)
	private int postalCode;

	@Column(nullable = false)
	private String mobileNumber;

	@Column(nullable = false)
	private String userImageUrl;

	@Column(unique = true, nullable = false)
	private String email;

	@Column(nullable = false)
	private String password;
}