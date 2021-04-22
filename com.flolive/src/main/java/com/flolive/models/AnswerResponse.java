package com.flolive.models;

import org.springframework.context.annotation.Scope;

@Scope("request")
public class AnswerResponse {

	private int answerStatus;
	private int pointsEarned;
	
	public int getAnswerStatus() {
		return answerStatus;
	}
	public void setAnswerStatus(int answerStatus) {
		this.answerStatus = answerStatus;
	}
	public int getPointsEarned() {
		return pointsEarned;
	}
	public void setPointsEarned(int pointsEarned) {
		this.pointsEarned = pointsEarned;
	}
	
}
