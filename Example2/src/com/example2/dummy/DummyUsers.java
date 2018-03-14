package com.example2.dummy;

import java.util.ArrayList;
import java.util.List;

public class DummyUsers  {

	private static DummyUsers instance;
	
	private List<String> users = new ArrayList<>();
	
	
	private DummyUsers(){}
	
	public DummyUsers getInstance(){
		if(instance == null){
			instance = new DummyUsers();
		}
		return instance;
	}
	
	
	
	

}
