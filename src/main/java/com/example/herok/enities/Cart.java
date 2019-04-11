package com.example.herok.enities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cart {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(nullable=false,name="email")
	private User userEmail;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(nullable=false,name="pid")
	private Product pid;
	
	@Column(nullable=false)
	private int quantity=1;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(User userEmail) {
		this.userEmail = userEmail;
	}

	public Product getPid() {
		return pid;
	}

	public void setPid(Product pid) {
		this.pid = pid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

	
}
