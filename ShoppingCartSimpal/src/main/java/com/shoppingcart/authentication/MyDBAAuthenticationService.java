package com.shoppingcart.authentication;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.shoppingcart.dao.AccountDAO;
import com.shoppingcart.entity.Account;

public class MyDBAAuthenticationService implements UserDetailsService {
	
	@Autowired
	private AccountDAO accountDAO;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Account account = accountDAO.findAccount(userName);
		System.out.println("Account" + account);
		
		if(account ==null){
			  throw new UsernameNotFoundException("User " //
	                    + userName + " was not found in the database");
		}
		
		String role = account.getUserRole();
		
	       List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
	       
	       GrantedAuthority authority = new SimpleGrantedAuthority("ROLE" + role);
	       
	       grantList.add(authority);
	       
	       boolean enabled = account.isActive();
	       boolean accountNonExpired = true;
	       boolean credentialsNonExpired = true;
	       boolean accountNonLocked = true;
	       
	       UserDetails userDetails =(UserDetails) new User(account.getUserName(), //
	                account.getPassword(), enabled, accountNonExpired, //
	                credentialsNonExpired, accountNonLocked, grantList);
	       
	       
		return userDetails;
	}

}
