package com.shoppingcart.testing;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.shoppingcart.entity.Orders;
import com.shoppingcart.entity.OrderDetails;
import com.shoppingcart.entity.Product;

public class DBTesting {
	
	
	public static void main(String[] argv) {
		
		SessionFactory factory = new Configuration().
				configure().
				addAnnotatedClass(Orders.class).
				addAnnotatedClass(OrderDetails.class).
				addAnnotatedClass(Product.class).buildSessionFactory();

Session session = factory.getCurrentSession();
session.beginTransaction();


	Orders orders = new Orders();
	
	orders.setId("1");
	orders.setAmount(32.00);
	orders.setCusAddress("123");
	orders.setCusEmail("abc@email.com");
	orders.setCusName("Sami");
	orders.setCusPhone("23333333");
	orders.setOrderDate(Date.valueOf("04/05/2018"));
	orders.setOrderNum(54354354);

	session.save(orders);
	session.getTransaction().commit();
	
	}

}
