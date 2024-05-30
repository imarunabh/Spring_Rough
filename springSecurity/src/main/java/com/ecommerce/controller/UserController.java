package com.ecommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@GetMapping("/account")
	public String account() {
		return "Hi Welcome";
		
	}
	
	@GetMapping("/balance")
	public String balance() {
		return "Your balance = 2000";
		
	}
	
	@GetMapping("/update")
	public String update() {
		
		return "We have an update for you";
		
	}
	
	@GetMapping("/main")
	public String mainPage() {
		return "This is a main page";
	}
	

}
