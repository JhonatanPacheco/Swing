package com.example2.dto;

import java.util.List;

import com.example2.enums.ERoles;

public class UserDTO {
	
	private String userId;
	private String name;
	private String others;
	
	private List<ERoles> roles;
	
	

	public UserDTO(String userId, String name, String others, List<ERoles> roles) {
		super();
		this.userId = userId;
		this.name = name;
		this.others = others;
		this.roles = roles;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOthers() {
		return others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

	public List<ERoles> getRoles() {
		return roles;
	}

	public void setRoles(List<ERoles> roles) {
		this.roles = roles;
	}
	
	

}
