package com.genuinecoder.learnspringsecurity.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.genuinecoder.learnspringsecurity.model.MyUser;

public interface MyUserRepository extends JpaRepository<MyUser, Long>{
	
	
	Optional<MyUser> findByUsername(String username);

}
