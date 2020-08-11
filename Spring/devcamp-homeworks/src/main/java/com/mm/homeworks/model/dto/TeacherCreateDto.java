package com.mm.homeworks.model.dto;

public class TeacherCreateDto {
	private String username;
	private String password;
	private String fullname;
	private String subject;
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getFullname() {
		return fullname;
	}
	public String getSubject() {
		return subject;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
}
