package com.tyss.medicalbookingstore.dao;

import java.util.List;

import com.tyss.medicalbookingstore.dto.ProductBean;

public interface ProductDao {
	
	public List<ProductBean> getAllProduct();
	public ProductBean getProductById(int productId);
	
	public boolean deleteProduct(int productId);
	public boolean addProduct(ProductBean product);
	public boolean modifyProduct(ProductBean productBean);
}
