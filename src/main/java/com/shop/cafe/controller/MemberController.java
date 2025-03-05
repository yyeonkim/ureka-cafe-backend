package com.shop.cafe.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class MemberController {
	
	@GetMapping("/members")
	public String getMembers() {
		return "ok";
	}
	
}
