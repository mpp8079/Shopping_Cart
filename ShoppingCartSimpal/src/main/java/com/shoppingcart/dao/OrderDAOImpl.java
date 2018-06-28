package com.shoppingcart.dao;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.shoppingcart.entity.Order;
import com.shoppingcart.entity.OrderDetails;
import com.shoppingcart.entity.Product;
import com.shoppingcart.model.CartInfo;
import com.shoppingcart.model.CartLineInfo;
import com.shoppingcart.model.CustomerInfo;
import com.shoppingcart.model.OrderDetailInfo;
import com.shoppingcart.model.OrderInfo;
import com.shoppingcart.model.PaginationResult;

@Transactional
public class OrderDAOImpl implements OrderDAO {

	
	
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	ProductDAO productDAO;

	private int getMaxOrderNum() {
		String sql = "Select max(o.orderNum) from " + Order.class.getName() + " o ";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(sql);
		Integer value = (Integer) query.uniqueResult();
		if (value == null) {
			return 0;
		}

		return value;
	}

	@Override
	public void saveOrder(CartInfo cartInfo) {
		Session session = sessionFactory.getCurrentSession();
		int orderNum = this.getMaxOrderNum()+1;
		Order order = new Order();
		
		order.setId(UUID.randomUUID().toString());
		order.setOrderNum(orderNum);
		order.setOrderDate(new Date());
		order.setAmount(cartInfo.getAmountTotal());
		
		CustomerInfo customerInfo = cartInfo.getCustomerInfo();
		
		order.setCusName(customerInfo.getName());
		order.setCusEmail(customerInfo.getEmail());
		order.setCusPhone(customerInfo.getPhone());
		order.setCusAddress(customerInfo.getAddress());
	
		session.persist(order);
		
		List<CartLineInfo> lines = cartInfo.getCartLines();
		for(CartLineInfo line : lines){
			OrderDetails detail = new OrderDetails();
			detail.setId(UUID.randomUUID().toString());
			detail.setOrderId(order);
			detail.setAmount(line.getAmount());
			detail.setPrice(line.getProductInfo().getPrice());
			detail.setQuanity(line.getQuantity());
			
			String code = line.getProductInfo().getCode();
			Product product = this.productDAO.findProduct(code);
			detail.setProductId(product);
			session.persist(detail);
		}
		
		cartInfo.setOrderNum(orderNum);
	}

	@Override
	public PaginationResult<OrderInfo> listOrderInfo(int page, int maxResult, int maxNavigationPage) {
		String sql = "Select new "+OrderInfo.class.getName()    
				+ "(ord.id, ord.orderDate, ord.orderNum, ord.amount, "
                + " ord.cusName, ord.cusAddress, ord.cusEmail, ord.cusPhone) "
                + "" + " from "
                + Order.class.getName() + " ord "//
                + " order by ord.orderNum desc";
		
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery(sql);
		return new PaginationResult<OrderInfo>(query,page,maxResult, maxNavigationPage);
	}
	
	public Order findOrder(String orderId){
		Session session = sessionFactory.getCurrentSession();
		Order order = session.get(Order.class,orderId);
		//Criteria crit = session.createCriteria(Order.class);
		//crit.add(Restrictions.eq("id",orderId));
		//return (Order) crit.uniqueResult();
		return order;
	}

	@Override
	public OrderInfo getOrderInfo(String orderId) {
		Order order = this.findOrder(orderId);
		if(order==null){
			return null;
		}
		return new OrderInfo(order.getId(), order.getOrderDate(),order.getOrderNum(),order.getAmount(),order.getCusName(),order.getCusAddress(),order.getCusEmail(),order.getCusPhone());
	}

	@Override
	public List<OrderDetailInfo> listOrderDetailInfos(String orderId) {
		 String sql = "Select new " + OrderDetailInfo.class.getName() //
	                + "(d.id, d.product.code, d.product.name , d.quanity,d.price,d.amount) "//
	                + " from " + OrderDetails.class.getName() + " d "//
	                + " where d.order.id = :orderId ";
	 
	        Session session = this.sessionFactory.getCurrentSession();
	 
	        Query query = session.createQuery(sql);
	        query.setParameter("orderId", orderId);
	 
	        return query.list();
	}

}
