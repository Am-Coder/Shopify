package com.example.herok.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.herok.enities.Product;
import com.example.herok.repositories.ProductRepo;

@Service
public class ProductService {
	
	@Autowired 
	ProductRepo productRepo;
	
	
	public List<Product> fetchClothes(){
		
		return productRepo.findByType("clothing");
		
	}
	
	public List<Product> fetchElectronics(){
		
		return productRepo.findByType("electronics");
	}
	
	public List<Product> fetchFootwear(){
		
		return productRepo.findByType("footwear");
	}
	
}
