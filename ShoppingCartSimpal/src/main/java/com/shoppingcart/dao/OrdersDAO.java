package com.shoppingcart.dao;

import java.util.List;

import com.shoppingcart.entity.Orders;

public interface OrdersDAO {
	
	public List<Orders> getAllOrders();
	
	
	public void addOrUpdateOrder(Orders order);
	
	
	public void deleteOrder(String id);
	
	
	public Orders getOrder(String id);
	
	

}
