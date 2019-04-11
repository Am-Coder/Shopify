package com.example.herok.nonentity;

import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Component
//@Projection
public interface CartDisplay {
	int getQuantity();
	String getProductname();
	String getPrice();
	String getAvailability();
	
//	private int quantity;
//
//	public CartDisplay(int quantity, String productname, float price, String availability) {
//		super();
//		this.quantity = quantity;
//		this.productname = productname;
//		this.price = price;
//		this.availability = availability;
//	}
//
//	private String productname;
//
//	private float price;
//
//	private String availability;
//
//	public int getQuantity() {
//		return quantity;
//	}
//
//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	}
//
//	public String getProductname() {
//		return productname;
//	}
//
//	public void setProductname(String productname) {
//		this.productname = productname;
//	}
//
//	public float getPrice() {
//		return price;
//	}
//
//	public void setPrice(float price) {
//		this.price = price;
//	}
//
//	public String getAvailability() {
//		return availability;
//	}
//
//	public void setAvailability(String availability) {
//		this.availability = availability;
//	}


}
