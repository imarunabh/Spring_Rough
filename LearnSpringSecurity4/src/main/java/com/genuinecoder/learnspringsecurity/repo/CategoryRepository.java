package com.genuinecoder.learnspringsecurity.repo;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;



public interface CategoryRepository  extends MongoRepository<com.genuinecoder.learnspringsecurity.model.Category, Integer>{
	
	
	 

}
