package com.shop.cafe.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import com.shop.cafe.dto.Product;
import com.shop.cafe.service.ProductService;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class ProductController {
	@Autowired
	ProductService prodService;
	
	@GetMapping("/products")
	public List<Product> getAllProducts() {
		try {
			return prodService.getAllProducts();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
