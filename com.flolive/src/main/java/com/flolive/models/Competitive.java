package com.flolive.models;

import org.springframework.context.annotation.Scope;

@Scope("prototype")
public class Competitive {

	public Competitive(int score, String userName) {
		User user = new User(userName);
		this.user= user;
		this.score = score;
	}
	private User user;
	private int score;

	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
