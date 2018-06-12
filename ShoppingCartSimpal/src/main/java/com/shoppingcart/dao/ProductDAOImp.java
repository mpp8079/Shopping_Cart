package com.shoppingcart.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shoppingcart.entity.Product;

@Repository
public class ProductDAOImp implements ProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	


	@Override
	@Transactional
	public List<Product> getProducts() {
		
		Session session = sessionFactory.getCurrentSession();
		List<Product> product = session.createQuery("from Products order by code").list();
		return product;
	}

	
	@Override
	@Transactional
	public void addOrUpdateProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		
	}
		


	@Override
	@Transactional
	public void deleteProduct(String code) {
		Session session = sessionFactory.getCurrentSession();
		Product product = sessionFactory.getCurrentSession().load(Product.class, code);
		if(null != product){
		session.delete(product);
		}

	}

	@Override
	@Transactional
	public Product getProduct(String code) {
		Session session = sessionFactory.getCurrentSession();
		Product product = (Product) session.get(Product.class, code);		
		return product;
	}


	@Override
	public void updateProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.update(product);
		
	}

}
