package com.shoppingcart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Order_Details")
public class OrderDetails {
	
	
	@Id
	@Column(name="ID" , nullable=false )
	private String id;
	
	
	@Column(name="Amount" , nullable=false )
	private double amount;
	
	@Column(name="Price" , nullable=false )
	private double price;
	
	@Column(name="Quanity" , nullable=false )
	private int quanity;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ORDER_ID", nullable=false,
	foreignKey = @ForeignKey(name="ORDER_DETAIL_ORD_FK"))
	private Order order;
	

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PRODUCT_ID", nullable=false,
	foreignKey = @ForeignKey(name="ORDER_DETAIL_PROD_FK"))
	private Product product;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuanity() {
		return quanity;
	}

	public void setQuanity(int quanity) {
		this.quanity = quanity;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrderId(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProductId(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", amount=" + amount + ", price=" + price + ", qt=" + quanity + ", orderId="
				+ order + ", productId=" + product + "]";
	}

	
	

}
