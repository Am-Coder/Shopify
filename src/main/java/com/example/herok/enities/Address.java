package com.example.herok.enities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Address {
	
	@Id
	private String address;
	
	@ManyToOne
	@JoinColumn(name="userEmail")
	private User userEmail;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public User getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(User userEmail) {
		this.userEmail = userEmail;
	}


	
}	
