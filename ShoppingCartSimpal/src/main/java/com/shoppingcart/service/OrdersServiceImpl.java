package com.shoppingcart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoppingcart.dao.OrderDAO;
import com.shoppingcart.entity.Orders;


@Service
public class OrdersServiceImpl implements OrdersService {
	
	
	@Autowired
	private OrderDAO orderDAO;

	
	
	@Override
	public List<Orders> getAllOrders() {		
		return orderDAO.getAllOrders();
	}

	@Override
	public void addOrUpdateOrder(Orders order) {
		 orderDAO.addOrUpdateOrder(order);
	}

	@Override
	public void deleteOrder(String id) {
		orderDAO.deleteOrder(id);
	}

	@Override
	public Orders getOrder(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
