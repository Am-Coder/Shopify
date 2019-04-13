package com.example.herok.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import com.example.herok.enities.Cart;
import com.example.herok.nonentity.CartDisplay;
import com.example.herok.repositories.CartRepo;

@Service
public class CartService {
	
	@Autowired
	private CartRepo cartRepo;
	
//	@Transactional
	public List<CartDisplay> fetchCart(String email) {
//		if(cartRepo.findByUserEmail(email).isEmpty()) {
//			System.out.println("Empty\n");
//			return List<CartDis>;
//		}
		
		return cartRepo.findByUserEmail(email);		
	}
	
	public void emptyCart(String email) {
		for(Cart c:cartRepo.findCartByUserEmail(email)) {
			cartRepo.delete(c);
		}
	}
	
	public void removeOneInCart(String pid,String email) {
		cartRepo.deleteByProductId(pid,email);
	}
}
