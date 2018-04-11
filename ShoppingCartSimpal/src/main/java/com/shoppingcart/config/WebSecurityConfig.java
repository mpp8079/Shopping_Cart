package com.shoppingcart.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
		
		//The pages requires login as Employee or Manager.
		// If no login, it will redirect to /login page.
		http.authorizeRequests().antMatchers("/orderList","/order","/accountInfo")
		.access("hasAnyRole('ROLE_EMPLOYEE','ROLE_MANAGER')");
		
		//For MANAGER only
		http.authorizeRequests().antMatchers("/product").access("hasRole('ROLE_MANAGER')");
		
		//AccessDenined Exception will Throw
		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
		
		
		//Config for Login Form
		http.authorizeRequests().and().formLogin()
		.loginProcessingUrl("j_spring_security_check")
		.loginPage("/login")
		.defaultSuccessUrl("/accountInfo")
		.failureUrl("/login?error=true")
		.usernameParameter("userName")
		.passwordParameter("password")
		.and().logout().logoutUrl("/logout").logoutSuccessUrl("/");
		
		
		
	}
	
	

}
