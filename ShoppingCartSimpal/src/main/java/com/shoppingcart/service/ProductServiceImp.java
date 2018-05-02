package com.shoppingcart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoppingcart.dao.ProductDAO;
import com.shoppingcart.entity.Products;


@Service
public class ProductServiceImp implements ProductService {
	
	@Autowired
	private ProductDAO productDAO;


	@Override
	public List<Products> getProducts() {		
		return productDAO.getProducts();
	}

	
	@Override
	public void addOrUpdateProduct(Products product) {
		productDAO.addOrUpdateProduct(product);

	}

	
	@Override
	public void deleteProduct(String code) {
		productDAO.deleteProduct(code);
		
	}

	@Transactional
	@Override
	public Products getProduct(String code) {
		// TODO Auto-generated method stub
		return null;
	}

}
