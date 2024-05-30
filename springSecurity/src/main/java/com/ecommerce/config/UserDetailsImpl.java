package com.ecommerce.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ecommerce.entities.Customer;
import com.ecommerce.repo.CustomerRepo;

public class UserDetailsImpl implements UserDetailsService{
	
	@Autowired
	private CustomerRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<Customer> customers = repo.findByEmail(username);
		if(customers.size()==0)
		{
			throw new UsernameNotFoundException("User Details are not found "+username);
		}
		return new SecurityCustomer(customers.get(0));
	}

}
