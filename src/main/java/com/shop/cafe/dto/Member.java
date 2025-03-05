package com.shop.cafe.dto;

import java.util.Date; // Date 패키지는 두 개가 있는데 일반적으로 util 사용

public class Member {
	private String nickname, email, pwd;
	private Date registrationDate;
	
	public Member() {}
	public Member(String nickname, String email, String pwd, Date registrationDate) {
	
		this.nickname = nickname;
		this.email = email;
		this.pwd = pwd;
		this.registrationDate = registrationDate;
	}
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	@Override
	public String toString() {
		return "Member [nickname=" + nickname + ", email=" + email + ", pwd=" + pwd + ", registrationDate="
				+ registrationDate + "]";
	}
}
