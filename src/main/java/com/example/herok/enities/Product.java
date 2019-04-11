package com.example.herok.enities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
	
@Entity
@Table(name="product")
public class Product {
	
	@Id
	private String pid;
	
	@Column(nullable=false,columnDefinition="varchar(55)")	
	private String productname;
	
	@Column(nullable=false,columnDefinition="varchar(25)")
	private String type;
	
	@Column(nullable=false)	
	private float price;
	
	@Column(nullable=false)
	private float rating;
	
	
	@Column(nullable=false,columnDefinition="varchar(35)")
	private String availability;
	
	@Column(nullable=false,columnDefinition="varchar(50)")
	private String brand;
	
	
	private String remarks;


	public String getPid() {
		return pid;
	}


	public void setPid(String pid) {
		this.pid = pid;
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


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public float getRating() {
		return rating;
	}


	public void setRating(float rating) {
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


	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
	
	
}	
