package com.tyss.medicalbookingstore.service;

import java.util.List;

import com.tyss.medicalbookingstore.dto.ProductBean;


public interface ProductServices 
{
	public List<ProductBean> getAllProduct();
	public ProductBean getProductById(int productId);
	
	public boolean deleteProduct(int productId);
	public boolean addProduct(ProductBean product);
	public boolean modifyProduct(ProductBean productBean);
	
}
