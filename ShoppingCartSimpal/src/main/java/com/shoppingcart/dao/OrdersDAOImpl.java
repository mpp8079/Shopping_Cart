package com.shoppingcart.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shoppingcart.entity.Orders;



@Repository
public class OrdersDAOImpl implements OrdersDAO {
	
	
	@Autowired
	private SessionFactory sessionFactory;


	@Override
	@Transactional
	public List<Orders> getAllOrders() {
		Session session = sessionFactory.getCurrentSession();
		List<Orders> orders = session.createQuery("from Orders order by id").list();
		return orders;
	}

	@Override
	@Transactional
	public void addOrUpdateOrder(Orders order) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(order);
	}

	@Override
	public void deleteOrder(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Orders getOrder(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
