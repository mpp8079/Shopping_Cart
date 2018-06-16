package com.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.shoppingcart.dao.OrderDAO;
import com.shoppingcart.dao.ProductDAO;
import com.shoppingcart.model.PaginationResult;
import com.shoppingcart.model.ProductInfo;
import com.shoppingcart.validator.CustomerInfoValidator;



@Controller
@Transactional
@EnableWebMvc
public class MainController {
	
	@Autowired
	private OrderDAO orderDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private CustomerInfoValidator customerInfoValidator;
	
	
	//Home Page
	@RequestMapping("/")
	public String home(){
		return "index";
	}
	
	
	
	//Product List Page
	@RequestMapping({"/productList"})
	public String listProductHandler(Model model, @RequestParam(value="name", defaultValue="") String likeName, 
			@RequestParam(value="page", defaultValue="1") int page){
		final int maxResult=5;
		final int maxNavigationPage=10;		
		PaginationResult<ProductInfo> result = productDAO.queryProducts(page, maxResult, maxNavigationPage,likeName);				
		model.addAttribute("paginationProducts", result);
		return "productList";
		
	}
	
	
	
	
	
}
