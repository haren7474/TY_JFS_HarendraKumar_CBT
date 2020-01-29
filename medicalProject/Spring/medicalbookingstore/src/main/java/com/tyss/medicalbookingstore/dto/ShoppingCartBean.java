package com.tyss.medicalbookingstore.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table
@SequenceGenerator(name = "cart_seq", initialValue = 11001, allocationSize = 12000)
public class ShoppingCartBean {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cart_seq")
	private int cartId;

	@CreationTimestamp
	@Column
	private LocalDateTime createDateTime;

	@UpdateTimestamp
	@Column
	private LocalDateTime updateDateTime;

	@OneToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="userId", nullable = false)
	private UserBean userBean;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "productId", nullable = false)
	private ProductBean productBean;
	
	@Column
	private int orderQuantity;

//	@JsonIgnore
//	@ManyToMany(cascade = CascadeType.MERGE)
//	@JoinTable(name = "CART_PRODUCT", joinColumns = @JoinColumn(name = "CART_ID"), inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID"))
//	private List<ProductBean> products;	
}
