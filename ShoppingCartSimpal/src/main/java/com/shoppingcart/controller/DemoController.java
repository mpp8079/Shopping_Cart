package com.shoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.entity.Orders;
import com.shoppingcart.entity.Product;
import com.shoppingcart.service.OrdersService;
import com.shoppingcart.service.ProductService;

@Controller
public class DemoController {
	
	
	@Autowired
	private ProductService productService;
	
	
	@Autowired
	private OrdersService ordersService;
	
	@RequestMapping("/")
	public String home(Model mode){		
		return "/index";
	}
	
	@RequestMapping("/products")
	public String showHome(Model mode){
		List<Product> allProducts = productService.getProducts();
		mode.addAttribute("products" ,allProducts);
		return "/products";
	}
	
	
	@RequestMapping("/showFormForProductAdd")
	public String showProductForm(Model theMode){
		Product theProduct = new Product();	
		theMode.addAttribute("products" ,theProduct);
		return "/ProductsForm";
	}
	
	
	
	
	@RequestMapping("/saveProduct")
	public String addProductOrUpdate(@ModelAttribute("products") Product product){		
		productService.addOrUpdateProduct(product);
		return "redirect:/products";
	}
	
	/*@RequestMapping("/upateProduct")
	public String updateProduct(@ModelAttribute("products") Products product){		
		productService.updateProduct(product);
		return "redirect:/products";
	}*/
	
	
	@RequestMapping("/deleteProduct")
	public String deleteProduct(@RequestParam("code") String codeID){		
		productService.deleteProduct(codeID);
		return "redirect:/products";
	}
	
	@RequestMapping("/showFormForProductUpdate")
	public String showProductFormUpdate(@RequestParam("code") String codeID,Model theMode){		
		Product theProduct =productService.getProduct(codeID);
		theMode.addAttribute("products" ,theProduct);
		return "ProductsForm";
	}
	

	//================================================================
	
	
	@RequestMapping("/orders")
	public String getAllOrders(Model mode){
		List<Orders> AllOrders = ordersService.getAllOrders();
		mode.addAttribute("orders" ,AllOrders);
		return "/orders";
	}
	
	
	@RequestMapping("/showOrderForm")
	public String showOrderForm(Model mode){
		Orders theOrder = new Orders();
		mode.addAttribute("orders", theOrder);
		return "/ordersForm";
	}
	
	@RequestMapping("/saveOrder")
	public String addOrderOrUpdate(@ModelAttribute("orders") Orders order){
		ordersService.addOrUpdateOrder(order);
		return "redirect:/orders";
	}
	
	@RequestMapping("/deleteOrder")
	public String deleteOrder(@RequestParam("id") String orderId){
		ordersService.deleteOrder(orderId);
		return "redirect:/orders";
		
	}
}
