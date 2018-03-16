package com.example2.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example2.dto.UserDTO;
import com.example2.enums.ERoles;

public class DummyUsers  {

	private static DummyUsers instance;
	
	private Map<String,UserDTO> users = new HashMap<>();
	
	
	private DummyUsers(){
		
		List<ERoles> roles = new ArrayList<>();
		roles.add(ERoles.Admin);
		users.put("usr1", new UserDTO("usr1","Jean","",roles));
		
		roles = new ArrayList<>();
		roles.add(ERoles.User);
		users.put("usr2", new UserDTO("usr2","Usuario2","",roles));
		
	}
	
	public static DummyUsers getInstance(){
		if(instance == null){
			instance = new DummyUsers();
		}
		return instance;
	}

	public Map<String, UserDTO> getUsers() {
		return users;
	}

	public void setUsers(Map<String, UserDTO> users) {
		this.users = users;
	}
	
	
	
	

}
