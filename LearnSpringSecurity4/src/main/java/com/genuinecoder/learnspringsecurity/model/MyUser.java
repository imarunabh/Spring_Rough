package com.genuinecoder.learnspringsecurity.model;

import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection="myuser")
public class MyUser {
	
    @org.springframework.data.annotation.Id
	private Long id;
	private String name;
	private String username;
	private String password;
	private String role;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	

}
