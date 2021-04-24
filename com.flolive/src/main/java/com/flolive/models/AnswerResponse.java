package com.flolive.models;

import org.springframework.context.annotation.Scope;

@Scope("request")
public class AnswerResponse {

	private int answerStatus;
	private Integer pointsEarned;
	
	public int getAnswerStatus() {
		return answerStatus;
	}
	public void setAnswerStatus(int answerStatus) {
		this.answerStatus = answerStatus;
	}
	public Integer getPointsEarned() {
		return pointsEarned;
	}
	public void setPointsEarned(Integer pointsEarned) {
		this.pointsEarned = pointsEarned;
	}
	
}
