package com.example.herok.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.herok.enities.Cart;
import com.example.herok.nonentity.CartDisplay;
import com.example.herok.repositories.CartRepo;

@Service
public class CartService {
	
	@Autowired
	private CartRepo cartRepo;
	
	
	public List<CartDisplay> fetchCart(String email) {
		if(cartRepo.findByUserEmail(email).isEmpty()) {
			return null;
		}
		
		return cartRepo.findByUserEmail(email);		
	}
	
	
}
