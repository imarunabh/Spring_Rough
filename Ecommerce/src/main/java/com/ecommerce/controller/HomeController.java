package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ecommerce.global.GlobalData;
import com.ecommerce.sevice.CategoryService;
import com.ecommerce.sevice.ProductService;

@Controller
public class HomeController {
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService productService;
	
	@GetMapping({"/","/home"})
	public String home(Model model) {
		return "index";
	}
	
	@GetMapping("/shop")
	public String shop(Model model) {
		model.addAttribute("categories",categoryService.getAllCategory());
		model.addAttribute("products",productService.getAllProduct());
		model.addAttribute("cartCount",GlobalData.cart.size());
		return "shop";
	}
	 
	@GetMapping("/shop/category/{id}")
	public String shopBycategory(Model model,@PathVariable int id) {
		model.addAttribute("categories",categoryService.getAllCategory());
		model.addAttribute("cartCount",GlobalData.cart.size());
		model.addAttribute("products",productService.getAllProductsByCategoryId(id));
		return "shop";
		
	}
	
	@GetMapping("/shop/viewproduct/{id}")
	public String viewProduct(Model model,@PathVariable int id) {
		model.addAttribute("product",productService.getProductById(id).get());
		return "viewProduct";
	}
	
	
	
	

}
