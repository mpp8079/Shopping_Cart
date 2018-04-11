package com.shoppingcart.entity;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Products")
public class Products {
	
	
	@Id
	@Column(name="Code" , nullable=false )
	private String code;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="Create_Date" , nullable=false )
	private Date createDate;
	
	
	@Lob
	@Column(name="Image" , nullable=false )
	private byte[] image;
	
	@Column(name="Name" , nullable=false )
	private String name;
	
	@Column(name="Price" , nullable=false )
	private double price;
	
	
	public Products() {
		
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public byte[] getImage() {
		return image;
	}


	public void setImage(byte[] image) {
		this.image = image;
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


	@Override
	public String toString() {
		return "Products [code=" + code + ", createDate=" + createDate + ", image=" + Arrays.toString(image) + ", name="
				+ name + ", price=" + price + "]";
	}
	

	
}
