package com.shoppingcart.service;

import java.util.List;

import com.shoppingcart.entity.Product;

public interface ProductService {
	
	public List<Product>  getProducts();
	
	public void addOrUpdateProduct(Product product);
	
	public void deleteProduct(String code);
	
	
	public Product getProduct(String code);
	
	public void updateProduct(Product product);
	
	

}
