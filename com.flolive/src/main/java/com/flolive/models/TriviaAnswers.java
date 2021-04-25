package com.flolive.models;

import org.springframework.context.annotation.Scope;

@Scope("prototype")
public class TriviaAnswers {
	
	private int questionId;
	private int correctAnswerID;
	
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public int getCorrectAnswerID() {
		return correctAnswerID;
	}
	public void setCorrectAnswerID(int correctAnswerID) {
		this.correctAnswerID = correctAnswerID;
	}
}

