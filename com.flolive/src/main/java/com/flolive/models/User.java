package com.flolive.models;

import org.springframework.context.annotation.Scope;

@Scope("prototype")
public class User {
	
	private static Integer idx=0;
	private Integer id;
	private String userName;
	
	public User(String userName){
		this.id = idx;
		this.userName = userName;
		idx++;
	}
	
	public Integer getId() {
		return id;
	}
	public String getUserName() {
		return userName;
	}
	
	
}
