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
public class Images {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(nullable=false,name="pid")
	private Product pid;
	
	@Column(nullable=false)
	private String directory;

	public Product getPid() {
		return pid;
	}

	public void setPid(Product pid) {
		this.pid = pid;
	}

	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}
	
	
	
}
