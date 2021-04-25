package com.flolive.models;

import java.util.List;

import org.springframework.context.annotation.Scope;

@Scope("prototype")
public class TriviaQuestion {
	private Question question;
	private List<Answer> answers;
	
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
		
}
