package com.example.herok.enities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ShoppingExperience {
	
	@Id
	private String userEmail;
	
	@Column(nullable=false,columnDefinition="varchar(300)")
	private String experience;

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}
	
	
}
