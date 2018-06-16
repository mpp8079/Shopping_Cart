package com.shoppingcart.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.shoppingcart.entity.Account;

@Transactional
public class AccountDAOImpl implements AccountDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Account findAccount(String userName) {
		Session session = sessionFactory.getCurrentSession();
		Account account = session.get(Account.class, userName);
		return account;
	}

}
