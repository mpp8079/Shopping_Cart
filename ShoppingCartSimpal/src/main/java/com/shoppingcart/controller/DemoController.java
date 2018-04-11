package com.shoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shoppingcart.entity.Products;
import com.shoppingcart.service.ProductService;

@Controller
public class DemoController {
	
	
	@Autowired
	private ProductService productService;
	
	
	@RequestMapping("/")
	public String home(Model mode){		
		return "index";
	}
	
	@RequestMapping("/products")
	public String showHome(Model mode){
		List<Products> allProducts = productService.getProducts();
		mode.addAttribute("products" ,allProducts);
		return "/products";
	}
	
	

}
