package com.genuinecoder.learnspringsecurity.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface CategoryRepository  extends JpaRepository<com.genuinecoder.learnspringsecurity.model.Category, Integer>{
	
	
	 

}
