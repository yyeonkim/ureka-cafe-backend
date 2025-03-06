package com.shop.cafe.controller;

import org.springframework.web.bind.annotation.RestController;

import com.shop.cafe.dto.Member;
import com.shop.cafe.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@PostMapping ("/login")
	public Map<String, String> login(@RequestBody Member member, HttpServletRequest req) {
		Map<String, String> resData = new HashMap<>();
		
		try {
			member = memberService.login(member);
			System.out.println(member);
			// 로그인 실패
			if (member == null) {
				resData.put("message", "Log in again.");
			} else {
				// 로그인 성공
				// HTTP Session: 메모리에 사용자가 로그인 했음을 기록한다.
				HttpSession session = req.getSession(); // 세션 한 칸 할당 받음
				System.out.println(session.getId()); // 세션 번호 확인
				session.setAttribute("member", member); // key 설정
				resData.put("message", "ok"); // 정상 처리 메시지 입력
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			resData.put("message", "Log in again.");
		}
		
		return resData;
	}
}
