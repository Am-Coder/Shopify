package com.example.herok.enities;
				
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity	
public class User {
	@Id
	private String email;
	
	public int getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(int phoneno) {
		this.phoneno = phoneno;
	}
	
	@Column(nullable=false)
	private String username;
	
	@Column(nullable=false)
	private String password;
	
	
	private String resetToken;
	
	
	@Column(nullable=false)
	private boolean enabled;
	
	
	@Column(unique=true,nullable=false)
	private int phoneno;
	
	
	@ManyToMany()
	private Set<Role> role;
	
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	
	public Set<Role> getRole() {
		return role;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getResetToken() {
		return resetToken;
	}

	public void setResetToken(String resetToken) {
		this.resetToken = resetToken;
	}
	
	
}
