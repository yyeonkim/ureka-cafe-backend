package com.shop.cafe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.cafe.dao.MemberDao;
import com.shop.cafe.dto.Member;

@Service
public class MemberService {
	@Autowired
	MemberDao memberDao;
	
	// member 생성 메소드: HTTP 바디 
	public void createMember(Member member) throws Exception {
			memberDao.createMember(member);
	}
	
	public Member login(Member member) throws Exception {
		return memberDao.login(member);
	}
}
