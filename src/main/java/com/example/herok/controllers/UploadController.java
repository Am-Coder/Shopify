package com.example.herok.controllers;	
      
										
import java.nio.file.Files;				
import java.nio.file.Path;				
import java.nio.file.Paths;				
										
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;	
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
										
@Controller								
public class UploadController {			
										
	private static String uploaddirectory="E://Herok//uploads";
										
										
	@GetMapping("/file/productupload")	
	public String imgupload(Model model,@RequestParam("files") MultipartFile[] files) {
										
		String message="status: ";		
										
		for(MultipartFile file: files) {
			Path path = Paths.get(uploaddirectory,file.getOriginalFilename());
			try {						
				Files.write(path,file.getBytes());
				message = message +"success";
			}catch(Exception e) {		
				e.printStackTrace();	
				message = message + "failed";
										
										
			}							
		}								
		model.addAttribute("message",message);
		return "Upload Success";		
										
	}									
	
	
}											
										