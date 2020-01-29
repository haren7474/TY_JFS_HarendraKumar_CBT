package com.tyss.medicalbookingstore.dto;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
@Table
@SequenceGenerator(name = "order_seq", initialValue = 12001, allocationSize = 13000)
public class OrderBean {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
	private int Id;

	@CreationTimestamp
	@Column
	private LocalDateTime orderPlacingTimestamp;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userId")
	private ShoppingCartBean shoppingCartBean;
	
	@Column
	private double totalPrice;
	
	@Column
	private String orderId;
	
	@Column
	private String orderStatus;
	
	@Column
	private String paymantStatus;
	
	
//	@OneToOne(cascade= CascadeType.MERGE)
//	@JoinColumn(name="userId", nullable = false)
//	private UserBean userBean;
//	
//	@OneToOne(cascade = CascadeType.MERGE)
//	@JoinColumn(name = "productId", nullable = false)
//	private ProductBean productBean;
//	
//	@Column
//	private int orderQuantity;
	
}



	
