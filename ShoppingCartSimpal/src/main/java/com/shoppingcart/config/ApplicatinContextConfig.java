package com.shoppingcart.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.shoppingcart.dao.AccountDAO;
import com.shoppingcart.dao.AccountDAOImpl;
import com.shoppingcart.dao.OrderDAO;
import com.shoppingcart.dao.OrderDAOImpl;
import com.shoppingcart.dao.ProductDAO;
import com.shoppingcart.dao.ProductDAOImpl;;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages="com.shoppingcart")
@PropertySource("classpath:hibernate.properties")
public class ApplicatinContextConfig {
	
	@Autowired
	private Environment env;
	
	
	@Bean
	public ResourceBundleMessageSource messageSource(){
		ResourceBundleMessageSource rb = new ResourceBundleMessageSource();
		rb.setBasenames(new String[] {"messages/validator"});
		return rb;
		
	}
	
	
	
	@Bean(name="viewResolver")
	public ViewResolver getViewResolver(){
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
		
	}
	
	
	/*@Bean(name="multipartResolver")
	public CommonsMultipartResolver multipartResolver(){
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
		return commonsMultipartResolver;
		
	}*/
	
	
	@Bean(name="dataSource")
	public DataSource getDataSource(){
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName(env.getProperty("jdbc.driver"));
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.user"));
		dataSource.setPassword(env.getProperty("jdbc.password"));
		
		System.out.println("DataSource" + dataSource);
		return dataSource;
		
	}
	
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) throws IOException{
		Properties prop = new Properties();
		
		//see hibernate properties
		prop.put("hibernate.dialect",env.getProperty("hibernate.dialect"));
		prop.put("hibernate.show_sql",env.getProperty("hibernate.show_sql"));
		prop.put("current_session_context_class",env.getProperty("current_session_context_class"));
		
		
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		
		
		//Package Contain Entity classes
		
		factoryBean.setPackagesToScan(new String[]{"com.shoppingcart.entity"});
		factoryBean.setDataSource(dataSource);
		factoryBean.setHibernateProperties(prop);
		factoryBean.afterPropertiesSet();
		
		
		SessionFactory sf = factoryBean.getObject();
		
		System.out.println("### setSessionFactory" +sf);
		return sf;
		
	}
	
	@Autowired
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){		
		HibernateTransactionManager transactionManager = 
				new HibernateTransactionManager(sessionFactory);
		
		return transactionManager;
		
	}
	
	@Bean(name="accountDAO")
	public AccountDAO getApplicantDAO(){
		return new AccountDAOImpl();
	}
	
	@Bean(name="productDAO")
	public ProductDAO getProductDAO(){
		return new ProductDAOImpl();
		
	}
	
	@Bean(name="orderDAO")
	public OrderDAO getOrderDAO(){
		return new OrderDAOImpl();
	}
	
	@Bean(name="accountDAO")
	public AccountDAO getAccountDAO(){
		return new AccountDAOImpl();
	}

}
