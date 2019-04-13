package com.example.herok.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.herok.AjaxMsg.AjaxPidMessage;
import com.example.herok.enities.Product;
import com.example.herok.nonentity.CartDisplay;
import com.example.herok.repositories.CartRepo;
import com.example.herok.repositories.ImageRepo;
import com.example.herok.repositories.ProductRepo;
import com.example.herok.service.CartService;
import com.fasterxml.jackson.core.JsonProcessingException;


@Controller
@RequestMapping(value="/mainsite",method= {RequestMethod.POST,RequestMethod.GET})
public class MainSiteController {
	
	@Autowired
	ProductRepo prodRepo;
	
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
					
					
//	@GetMapping("/fetch")
//	@ResponseBody	
//	public ResponseEntity<byte[]> fetch() throws JsonProcessingException {
//		Optional<Product> getting = prodRepo.findByBrand("Nike");
//		if(getting.isPresent()) {
//			Optional<Images>getimg=imageRepo.findByPid(getting.get());
//		    InputStream in = servletContext.getResourceAsStream("/WEB-INF/images/image-example.jpg");
//
//			if(getimg.isPresent()) {
//				String directory = getimg.get().getDirectory();
//				
//				byte[] bytes=IOUtils.toByteArray(in);
//				return ResponseEntity
//						.ok()
//						.contentType(MediaType.IMAGE_JPEG)
//						.body(bytes);
//			}
//			return null;
//		}			
//		return null;
//	}				
					
	@GetMapping("/fetchimage")
	@ResponseBody	
	public Product fetchimage() throws JsonProcessingException {
//		ObjectMapper om = new ObjectMapper();
		Optional<Product> getting = prodRepo.findByBrand("Nike");
		if(getting.isPresent()) {
			return getting.get();
		}			
//		String res=om.writeValueAsString(prodRepo.getOne("1"));
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
		System.out.println("Hello");
		System.out.println("Hell");
		
		
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
}
