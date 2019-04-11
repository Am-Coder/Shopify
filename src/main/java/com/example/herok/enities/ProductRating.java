package com.example.herok.enities;
	
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
	
@Entity
public class ProductRating {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="userEmail")
	private User userEmail;
	
	@ManyToOne
	@JoinColumn(name="pid")	
	private Product pid;
	
	
	private String review;
	
	
	private float stars;
	
	


	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public float getStars() {
		return stars;
	}

	public void setStars(float stars) {
		this.stars = stars;
	}
	
	
}	
	