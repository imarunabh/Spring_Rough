package com.genuinecoder.learnspringsecurity.global;

import java.util.ArrayList;
import java.util.List;

import com.genuinecoder.learnspringsecurity.model.Product;



public class GlobalData {
	
	public static List<Product> cart;
	
	static {
		cart = new ArrayList<Product>();
	}
	

}
