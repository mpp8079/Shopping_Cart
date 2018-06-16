package com.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.shoppingcart.dao.OrderDAO;
import com.shoppingcart.dao.ProductDAO;
import com.shoppingcart.model.ProductInfo;
import com.shoppingcart.validator.ProductInfoValidator;

@Controller
@Transactional
@EnableWebMvc
public class AdminController {
	
	
	@Autowired
	private OrderDAO orderDAO;
	
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private ProductInfoValidator productInfoValidator;
	
	
	@Autowired
	private ResourceBundleMessageSource messageSource;
	
	
	@InitBinder
    public void myInitBinder(WebDataBinder dataBinder) {
        Object target = dataBinder.getTarget();
        if (target == null) {
            return;
        }
        System.out.println("Target=" + target);
 
        if (target.getClass() == ProductInfo.class) {
            dataBinder.setValidator(productInfoValidator);
            // For upload Image.
            dataBinder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
        }
    }
	
	
	
	//Get Login Page
	@RequestMapping(value={"/login"}, method=RequestMethod.GET)
	public String login(Model model){
		return "login";
	}

	
	@RequestMapping(value={"/product"}, method=RequestMethod.GET)
	public String product(Model model, @RequestParam(value="code", defaultValue="") String code){
		
		ProductInfo productInfo = null;
		if(code != null && code.length()>0){
			productInfo = productDAO.findProductInfo(code);
		}
		
		if(productInfo ==null){
			productInfo = new ProductInfo();
			productInfo.setNewProduct(true);
		}
		
		model.addAttribute("productForm", productInfo);
		
		return "product";
		
		
		
		
		
	}
	
	

}
