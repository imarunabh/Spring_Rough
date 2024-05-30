package com.learn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.entity.User;
import com.learn.repo.UserRepository;

@RestController
public class HomeController {
	@Autowired
	private UserRepository repository;
	
	@PostMapping("/create")
	public User createUser(@RequestBody User user){
		System.out.println(user);
		return repository.save(user);
		
	}

}
