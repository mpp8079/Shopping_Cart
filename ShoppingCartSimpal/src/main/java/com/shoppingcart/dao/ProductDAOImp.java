package com.shoppingcart.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shoppingcart.entity.Products;

@Repository
public class ProductDAOImp implements ProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	


	@Override
	@Transactional
	public List<Products> getProducts() {
		
		Session session = sessionFactory.getCurrentSession();
		List<Products> products = session.createQuery("from Products order by code").list();
		return products;
	}

	
	@Override
	@Transactional
	public void addOrUpdateProduct(Products product) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		
	}

	@Override
	@Transactional
	public void deleteProduct(String code) {
		Session session = sessionFactory.getCurrentSession();
		Products product = sessionFactory.getCurrentSession().load(Products.class, code);
		if(null != product){
		session.delete(product);
		}

	}

	@Override
	@Transactional
	public Products getProduct(String code) {
		Session session = sessionFactory.getCurrentSession();
		Products product = (Products) session.get(Products.class, code);		
		return product;
	}

}
