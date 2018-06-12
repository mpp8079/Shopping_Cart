package com.shoppingcart.model;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.shoppingcart.entity.Product;

public class ProductInfo {

	
	private String code;
	private String name;
	private double price;
	
	private CommonsMultipartFile fileData;
	
	private boolean newProduct=false;
	
	public ProductInfo() {
	
	}
	
	public ProductInfo(Product product){
		this.code=product.getCode();
		this.name=product.getName();
		this.price=product.getPrice();
		
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public CommonsMultipartFile getFileData() {
		return fileData;
	}

	public void setFileData(CommonsMultipartFile fileData) {
		this.fileData = fileData;
	}

	public boolean isNewProduct() {
		return newProduct;
	}

	public void setNewProduct(boolean newProduct) {
		this.newProduct = newProduct;
	}
	
	
}