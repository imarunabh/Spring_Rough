package com.ecommerce.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ecommerce.entities.User;
import com.ecommerce.repo.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	 UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user=repository.findByUsername(username);
		if(user.isPresent()) {
			var userObj = user.get();
			return org.springframework.security.core.userdetails.User.builder()
					                                                  .username(userObj.getUsername())
					                                                  .password(userObj.getPassword())
					                                                  .roles(getRoles(userObj))
					                                                  .build();
		}
		else {
			throw new UsernameNotFoundException(username);
		}
		
	}
	
	public String[] getRoles(User user) {
		if(user.getRole()==null) {
			return new String[] {"USER"};
		}
		return user.getRole().split(",");
	}
	
	

}
