package com.javatechie.google.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeoCoder {
	
	@GetMapping("/test")
	public String test() {
		return "service up";
	}

}
