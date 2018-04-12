package com.shoppingcart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoppingcart.dao.OrdersDAO;
import com.shoppingcart.entity.Orders;


@Service
public class OrdersServiceImpl implements OrdersService {
	
	
	@Autowired
	private OrdersDAO ordersDAO;

	
	@Transactional
	@Override
	public List<Orders> getAllOrders() {		
		return ordersDAO.getAllOrders();
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
