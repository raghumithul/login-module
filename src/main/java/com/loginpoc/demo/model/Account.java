package com.loginpoc.demo.model;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Account {
	
	@Id
	private String id;
	private String username;
	private String password;
	private List<Role> roles;
	
	
	public Account(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	
}
