package com.ecommerce.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecommerce.entities.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{
	
	
	List<Customer> findByEmail(String email);

}
