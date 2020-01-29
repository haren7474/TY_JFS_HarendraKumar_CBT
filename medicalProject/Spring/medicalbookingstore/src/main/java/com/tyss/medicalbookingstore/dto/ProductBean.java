package com.tyss.medicalbookingstore.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Future;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table
@SequenceGenerator(name = "product_seq", initialValue = 1001, allocationSize = 1499)
public class ProductBean {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
	private int productId;
	
	@Column(nullable = false)
	private String productName;

	@Column(nullable = false)
	private int productQuantity;

	@Column(nullable = false)
	private double productPrice;
	
	@Column(nullable = false)
	private String productComments;

	@Column(nullable = false)
	private String productImageUrl;
	
	@Column(nullable =  false)
	@Future
	private LocalDate expiryDate;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "sellerId", nullable = false)
	private UserBean userBean;
	
//	
//	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "products")
//    private List<ShoppingCartBean> carts;

}
