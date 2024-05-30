package com.genuinecoder.learnspringsecurity.repo;

import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.genuinecoder.learnspringsecurity.model.Product;



public interface ProductRepository extends MongoRepository<Product, Long>{
	
	List<Product> findAllByCategory_Id(int id);
	

}
