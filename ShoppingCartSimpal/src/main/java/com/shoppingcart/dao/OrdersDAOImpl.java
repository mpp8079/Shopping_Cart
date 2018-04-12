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
	public List<Orders> getAllOrders() {
		Session session = sessionFactory.openSession();
		List<Orders> orders = session.createQuery("from Orders order by id").list();
		return orders;
	}

	@Override
	public void addOrUpdateOrder(Orders order) {
		// TODO Auto-generated method stub

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
