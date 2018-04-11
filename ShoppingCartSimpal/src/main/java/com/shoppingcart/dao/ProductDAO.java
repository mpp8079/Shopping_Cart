package com.shoppingcart.dao;

import java.util.List;

import com.shoppingcart.entity.Products;

public interface ProductDAO {
	
	public List<Products> getProducts();
	
	public void addOrUpdateProduct(Products product);
	
	public void deleteProduct(String code);
	
	public Products getProduct(String code);
	
	
	

}
