package com.shoppingcart.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shoppingcart.entity.Products;

@Repository
public class ProductDAOImp implements ProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Products> getProducts() {
		
		Session session = sessionFactory.openSession() ;
		List<Products> products = session.createQuery("from Products order by code").list();
		return products;
	}

	@Override
	public void addOrUpdateProduct(Products product) {
		

	}

	@Override
	public void deleteProduct(String code) {
		Session session = sessionFactory.openSession();
		session.delete(code);
		

	}

	@Override
	public Products getProduct(String code) {
		
		return null;
	}

}
