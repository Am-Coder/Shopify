package com.example.herok.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.herok.AjaxMsg.AjaxPidMessage;
import com.example.herok.AjaxMsg.AjaxQuantityMessage;
import com.example.herok.enities.Product;
import com.example.herok.nonentity.CartDisplay;
import com.example.herok.nonentity.ProductDisplay;
import com.example.herok.repositories.CartRepo;
import com.example.herok.repositories.ImageRepo;
import com.example.herok.service.CartService;
import com.example.herok.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;


@Controller
@RequestMapping(value="/mainsite",method= {RequestMethod.POST,RequestMethod.GET})
public class MainSiteController {
	
	@Autowired
	ProductService prodService;
	
	@Autowired
	ImageRepo imageRepo;
	
	@Autowired
	CartRepo cartRepo;
	
	@Autowired
	CartService cartService;
	
	@GetMapping({"/home","/mainhome"})
	public String mainsite() {
		
		return "mainsite/index";
	}				

	
					
	@GetMapping("/fetch/{type}/{page}")
	@ResponseBody	
	public List<ProductDisplay> fetchProduct(@PathVariable("type") String type,@PathVariable("page") int page) throws JsonProcessingException {
		System.out.println(type + "----" + page);
		if(type.equals("Clothing")){
//			System.out.println("clthes--"+prodService.fetchClothes(page,1));
			return prodService.fetchClothes(page,1);
		}
		else if (type.equals("Footwear")) {
//			System.out.println("footew--"+prodService.fetchFootwear(page,1));
			return prodService.fetchFootwear(page,1);
		}
		else if (type.equals("Electronics")) {
//			System.out.println("electronics--"+prodService.fetchElectronics(page,1));
			return prodService.fetchElectronics(page,1);
		}
		
		return null;
	}				
					
					
	@GetMapping({"/cart.html","/cart"})
	public String cart() {
		return "mainsite/cart";
	}
	
	@GetMapping({"/checkout.html","/checkout"})
	public String checkout() {
		return "mainsite/checkout";
	}
	
	@GetMapping({"/category.html","/category"})
	public String category() {
		return "mainsite/category";
	}
	
	@GetMapping({"/product.html","/product"})
	public String product() {
		return "mainsite/product";
	}
	
	@GetMapping("/fetchCart")
	@ResponseBody
	public List<CartDisplay> getCart(String email){
//		System.out.println("Hello");
//		System.out.println("Hell");
		
		
		return cartService.fetchCart("abc@abc.com");
//		return cartRepo.findInCart("abc@abc.com");
	}
	
	@ResponseBody
	@PostMapping("/clearCart")
	public void emptyCart() {
		System.out.println("Hell Comes");
		cartService.emptyCart("abc@abc.com");
	}
	
	@ResponseBody
	@PostMapping("/removeItem")
	public void removeItem(@RequestBody AjaxPidMessage msg) {
		System.out.println("Hell Comes Here" + "---"+msg.getPid());
		cartService.removeOneInCart(msg.getPid(),"abc@abc.com");
	}
	
	@ResponseBody
	@PostMapping("/quantityUpdate")
	public void quantityUpdate(@RequestBody AjaxQuantityMessage msg) {
		System.out.println(msg.getPid()+"----"+msg.getQuantity());
		cartService.updateQuantity(msg,"abc@abc.com");
		
	}
	
	@ResponseBody
	@PostMapping("/addToCart")
	public void addItemToCart(@RequestBody AjaxPidMessage msg) {
		System.out.println("Adding---" + msg.getPid());
		cartService.addToCart(msg.getPid(), "abc@abc.com");
	}
	
	@ResponseBody
	@PostMapping("/fetchCarousel/{type}")
	public List<ProductDisplay> fetchCarousel(@PathVariable String type) {
		if(type.equals("Electronics")) {
			return prodService.fetchElectronics(0,3);
			
			
		}else if (type.equals("Clothing")) {
			return prodService.fetchClothes(0,3);

			
		}else if(type.equals("Footwear")) {
			return prodService.fetchFootwear(0,3);

			
		}
		return null;
	}
}
