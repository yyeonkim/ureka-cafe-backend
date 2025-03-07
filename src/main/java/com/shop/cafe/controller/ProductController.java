package com.shop.cafe.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import com.shop.cafe.dto.Product;
import com.shop.cafe.service.ProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class ProductController {
	@Autowired
	ProductService prodService;
	Map<String, Object> storage = new HashMap<>();
	
	@GetMapping("/products")
	public List<Product> getAllProducts() {
		try {
			Object obj = storage.get("firstPageProducts");
			
			if (obj == null) {
				List<Product> list = prodService.getAllProducts();
				storage.put("firstPageProducts",  list);
				return list;
			}
			
			return (List<Product>) obj;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
