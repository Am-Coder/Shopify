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
	private String pid;
	
	private Integer quantity;
	
	private String productname;

	private String src;
	
	private Float price;

	private String availability;
	
	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}


	
	
	
	




	public CartDisplay(String pid, Integer quantity, String productname, String src, Float price, String availability) {
		super();
		this.pid = pid;
		this.quantity = quantity;
		this.productname = productname;
		this.src = src;
		this.price = price;
		this.availability = availability;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
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
