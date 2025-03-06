package com.shop.cafe.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class CartController {
	@PostMapping("/cart")
	public String addCart(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		System.out.println("Implemented addCart: " + session);
		return "ok";
	}
	
}
