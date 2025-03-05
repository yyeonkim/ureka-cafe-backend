package com.shop.cafe.controller;

import org.springframework.web.bind.annotation.RestController;

import com.shop.cafe.dto.Member;
import com.shop.cafe.service.MemberService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class MemberController {
	@Autowired
	MemberService memberService;
	
	@PostMapping("/member")
	public Map<String, String> createMember(@RequestBody Member member) {
		
		Map<String, String> resData = new HashMap<>();
		
		try {
			memberService.createMember(member);
			resData.put("message", "ok"); // 정상 처리 메시지 입력
		} catch (Exception e) {
			e.printStackTrace();
			resData.put("message", e.getMessage()); // 에러 메시지 입력
		}
		
		return resData;
	}
}
