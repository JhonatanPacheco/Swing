package com.example2.enums;

public enum ERoles {
	Admin(1,"Admin"),
	User(2,"User");
	
	private int id;
	private String description;
	
	ERoles(int id, String desc){
		this.id = id;
		this.description = desc;
		
	}
	
	public final String getDescription() {
		return this.description;
	}
	public final int getId() {
		return this.id;
	}
	

}
