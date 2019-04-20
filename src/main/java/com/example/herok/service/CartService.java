package com.example.herok.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import com.example.herok.AjaxMsg.AjaxQuantityMessage;
import com.example.herok.enities.Cart;
import com.example.herok.nonentity.CartDisplay;
import com.example.herok.repositories.CartRepo;
import com.example.herok.repositories.ProductRepo;
import com.example.herok.repositories.UserRepo;

@Service
public class CartService {
	
	@Autowired
	private CartRepo cartRepo;
	
	@Autowired
	private ProductRepo prodRepo;
	
	@Autowired
	private UserRepo userRepo;
	
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
	
	public void updateQuantity(AjaxQuantityMessage msg,String email) {
		if(msg.getQuantity()!=0)
			cartRepo.updateQuantity(msg.getPid(),msg.getQuantity(),email);

	}
	
	public void addToCart(String pid,String email) {
		System.out.println(userRepo.findByEmail(email));
		System.out.println(prodRepo.findById(pid).get());

		Cart cart = new Cart();
//		if(prodRepo.findById(pid).g)
		cart.setPid(prodRepo.findById(pid).get());;
		cart.setUserEmail(userRepo.findByEmail(email).get());
		if(cartRepo.findByUserEmailAndPid(email, pid) == null) {
			System.out.println("Inside addToCart");
			cartRepo.save(cart);
		}
	}
}
