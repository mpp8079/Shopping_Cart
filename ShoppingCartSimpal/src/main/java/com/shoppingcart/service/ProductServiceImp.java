package com.shoppingcart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoppingcart.dao.ProductDAO;
import com.shoppingcart.entity.Product;


@Service
public class ProductServiceImp implements ProductService {
	
	@Autowired
	private ProductDAO productDAO;


	@Override
	public List<Product> getProducts() {		
		return productDAO.getProducts();
	}

	
	@Override
	public void addOrUpdateProduct(Product product) {
		productDAO.addOrUpdateProduct(product);

	}

	
	@Override
	public void deleteProduct(String code) {
		productDAO.deleteProduct(code);
		
	}


	@Override
	public Product getProduct(String code) {		
		return productDAO.getProduct(code);
	}


	@Override
	public void updateProduct(Product product) {
		productDAO.updateProduct(product);
		
	}


	

}
