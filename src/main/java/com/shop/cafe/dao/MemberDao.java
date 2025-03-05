package com.shop.cafe.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.shop.cafe.dto.Member;

@Repository
public class MemberDao {
	@Value("${spring.datasource.driver-class-name}")
	private String DB_DRIVER;
	
	@Value("${spring.datasource.url}")
	private String DB_URL;
	
	@Value("${spring.datasource.username}")
	private String DB_USER;
	
	@Value("${spring.datasource.password}")
	private String DB_PW;
	
	public void createMember(Member member) throws Exception {
		Class.forName(DB_DRIVER);
		String sql = "INSERT INTO member(nickname, email, pwd) VALUES(?, ?, ?)";

		try(
			Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PW);
			PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			pstmt.setString(1, member.getNickname());
			pstmt.setString(2, member.getEmail());
			pstmt.setString(3, member.getPwd());
			int i = pstmt.executeUpdate();
			System.out.println(i + "행이 생성되었습니다.");
		}
	}
}
