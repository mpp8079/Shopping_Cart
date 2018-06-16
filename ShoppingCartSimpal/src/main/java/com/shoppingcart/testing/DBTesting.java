package com.shoppingcart.testing;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.shoppingcart.entity.Order;
import com.shoppingcart.entity.OrderDetails;
import com.shoppingcart.entity.Product;

public class DBTesting {
	
	
	public static void main(String[] argv) {
		
		SessionFactory factory = new Configuration().
				configure().
				addAnnotatedClass(Order.class).
				addAnnotatedClass(OrderDetails.class).
				addAnnotatedClass(Product.class).buildSessionFactory();

Session session = factory.getCurrentSession();
session.beginTransaction();


	Order order = new Order();
	
	order.setId("1");
	order.setAmount(32.00);
	order.setCusAddress("123");
	order.setCusEmail("abc@email.com");
	order.setCusName("Sami");
	order.setCusPhone("23333333");
	order.setOrderDate(Date.valueOf("04/05/2018"));
	order.setOrderNum(54354354);

	session.save(order);
	session.getTransaction().commit();
	
	}

}
