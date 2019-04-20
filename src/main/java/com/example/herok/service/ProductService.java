package com.example.herok.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.herok.nonentity.ProductDisplay;
import com.example.herok.repositories.ProductRepo;

@Service
public class ProductService {
	
	@Autowired 
	ProductRepo productRepo;
	
	
	public List<ProductDisplay> fetchClothes(int page){
		
		return productRepo.findByType("clothing",PageRequest.of(page, 10));
		
	}
	
	public List<ProductDisplay> fetchElectronics(int page){
		
		return productRepo.findByType("electronics",PageRequest.of(page, 1));
	}
	
	public List<ProductDisplay> fetchFootwear(int page){
		
		return productRepo.findByType("footwear",PageRequest.of(page, 10));
	}
	
}
