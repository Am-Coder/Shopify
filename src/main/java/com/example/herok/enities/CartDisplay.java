package com.example.herok.enities;

import org.springframework.data.rest.core.config.Projection;

@Projection(types= {Cart.class,Product.class})
public interface CartDisplay {
	
	
//	@Value("#{target.getQuantity()}")
	Integer getQuantity(); //Don't use int,float because it is not serializable to json
	String getProductname();
	Float getPrice();
	String getAvailability();
	
//	private Integer quantity;
//
//	public CartDisplay(Integer quantity, String productname, float price, String availability) {
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
//
//
//	public Integer getQuantity() {
//		return quantity;
//	}
//
//	public void setQuantity(Integer quantity) {
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
