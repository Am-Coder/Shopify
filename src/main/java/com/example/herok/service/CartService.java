package com.example.herok.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import com.example.herok.nonentity.CartDisplay;
import com.example.herok.repositories.CartRepo;

@Service
public class CartService {
	
	@Autowired
	private CartRepo cartRepo;
	
	@Transactional
	public List<CartDisplay> fetchCart(String email) {
		if(cartRepo.findByUserEmail(email).isEmpty()) {
			System.out.println("Empty\n");
			return null;
		}
		
		return cartRepo.findByUserEmail(email);		
	}
	
	
}
