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

	@Transactional
	@Override
	public List<Products> getProducts() {		
		return productDAO.getProducts();
	}

	@Transactional
	@Override
	public void addOrUpdateProduct(Products product) {
		// TODO Auto-generated method stub

	}

	@Transactional
	@Override
	public void deleteProduct(String code) {
		// TODO Auto-generated method stub

	}

	@Transactional
	@Override
	public Products getProduct(String code) {
		// TODO Auto-generated method stub
		return null;
	}

}
