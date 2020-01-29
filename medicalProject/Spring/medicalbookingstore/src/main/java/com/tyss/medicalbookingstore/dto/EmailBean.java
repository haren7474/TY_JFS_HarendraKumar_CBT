package com.tyss.medicalbookingstore.dto;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table
@SequenceGenerator(name = "email_seq", initialValue = 9001, allocationSize = 9999)
public class EmailBean {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "email_seq")
	private int emailUniqueId;

	@Column(nullable = false)
	private String emailSubject;

	@Column(nullable = false)
	private String emailBody;

	@CreationTimestamp
	@Column
	private LocalDateTime createDateTime;

	@UpdateTimestamp
	@Column
	private LocalDateTime updateDateTime;

	@OneToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="emailSenderId", nullable = false)
	private UserBean emailSenderBean;
	
	@OneToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="emailReceiverId", nullable = false)
	private UserBean emailReceiverBean;

}
