package com.example.herok.nonentity;

import javax.persistence.Column;

public class ProductDisplay {
	
	private String productname;
	
	private String type;
	
	private Float price;
	
	private Float rating;
	
	private String availability;
	
	private String brand;
	
	private String directory;

	
	
	public ProductDisplay(String productname, String type, Float price, Float rating, String availability, String brand,
			String directory) {
		super();
		this.productname = productname;
		this.type = type;
		this.price = price;
		this.rating = rating;
		this.availability = availability;
		this.brand = brand;
		this.directory = directory;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}
	
	

}
