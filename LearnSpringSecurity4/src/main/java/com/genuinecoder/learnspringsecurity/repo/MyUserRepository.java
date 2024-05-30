package com.genuinecoder.learnspringsecurity.repo;

import java.util.Optional;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.genuinecoder.learnspringsecurity.model.MyUser;

public interface MyUserRepository extends MongoRepository<MyUser, Long>{
	
	
	Optional<MyUser> findByUsername(String username);

}
