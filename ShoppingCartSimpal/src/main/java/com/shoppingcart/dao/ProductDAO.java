package com.shoppingcart.dao;

import java.util.List;

import com.shoppingcart.entity.Product;

public interface ProductDAO {
	
	public List<Product> getProducts();
	
	public void addOrUpdateProduct(Product product);
	
	public void deleteProduct(String code);
	
	public Product getProduct(String code);

	public void updateProduct(Product product);
	
	
	
	

}
