package com.shoppingcart.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.shoppingcart.model.CartInfo;
import com.shoppingcart.model.OrderDetailInfo;
import com.shoppingcart.model.OrderInfo;
import com.shoppingcart.model.PaginationResult;


@Transactional 
public class OrderDAOImpl implements OrderDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private ProductDAO productDAO;


	@Override
	public void saveOrder(CartInfo cartInfo) {
		// TODO Auto-generated method stub

	}

	@Override
	public PaginationResult<OrderInfo> listOrderInfo(int page, int maxResult, int maxNavigationPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderInfo getOrderInfo(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDetailInfo> listOrderDetailInfos(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

}
