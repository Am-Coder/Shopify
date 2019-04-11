package com.example.herok.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.herok.enities.Product;
import com.example.herok.repositories.ProductRepo;

@Service
public class ProductFetch {
	
	@Autowired 
	ProductRepo productrepo;
	
	public List<Product> fetchAll(){
		
		return productrepo.findAll();
		
	}
	
}
