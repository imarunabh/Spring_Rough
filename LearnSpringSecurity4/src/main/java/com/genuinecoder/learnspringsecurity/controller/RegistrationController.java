package com.genuinecoder.learnspringsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.genuinecoder.learnspringsecurity.model.MyUser;
import com.genuinecoder.learnspringsecurity.repo.MyUserRepository;

@RestController
public class RegistrationController {
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private MyUserRepository myUserRepository;
	
	@PostMapping("/register/user")
	public MyUser createUser(@RequestBody MyUser user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return myUserRepository.save(user);
	}

}
