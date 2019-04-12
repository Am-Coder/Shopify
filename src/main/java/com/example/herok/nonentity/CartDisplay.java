package com.example.herok.nonentity;

import org.springframework.stereotype.Component;

//@Projection(types= {Cart.class,Product.class})

//@Component Don't use component this it gives error no bean like java.lang.Integer
public class CartDisplay {
	
	
//	@Value("#{target.getQuantity()}")
//	Integer getQuantity(); //Don't use int,float because it is not serializable to json
//	String getProductname();
//	Float getPrice();
//	String getAvailability();
//	
	private Integer quantity;
	
	private String productname;

	private Float price;

	private String availability;
	
	
	
	
	public CartDisplay(Integer quantity, String productname, float price, String availability) {
		super();
		this.quantity = quantity;
		this.productname = productname;
		this.price = price;
		this.availability = availability;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}


}
