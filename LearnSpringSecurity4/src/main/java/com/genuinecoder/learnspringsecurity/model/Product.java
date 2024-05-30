package com.genuinecoder.learnspringsecurity.model;



import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.annotation.Generated;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection="Product")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	  
	@org.springframework.data.annotation.Id
	private Long Id;
	private String name;
	
	
	@DBRef
	private Category category;
	private double price;
	private double weight;
	private String description;
	private String imageName;

	
	

}
