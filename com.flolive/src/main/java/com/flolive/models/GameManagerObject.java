package com.flolive.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

@Scope("prototype")
public class GameManagerObject {

	private TriviaBoardAnswers triviaBoardAnswers;
	private TriviaQuestionList triviaQuestionList;
	
//	@Autowired
//	public GameManagerObject(TriviaBoardAnswers triviaBoardAnswers,
//			 TriviaQuestionList triviaQuestionList) {
//		this.triviaBoardAnswers = triviaBoardAnswers;//new TriviaBoardAnswers();
//		this.triviaQuestionList = triviaQuestionList;//new TriviaQuestionList();
//	}
	
	public GameManagerObject() {
		this.triviaBoardAnswers = new TriviaBoardAnswers();
		this.triviaQuestionList = new TriviaQuestionList();
	}

	public TriviaBoardAnswers getTriviaBoardAnswers() {
		return triviaBoardAnswers;
	}
	public void setTriviaBoardAnswers(TriviaBoardAnswers triviaBoardAnswers) {
		this.triviaBoardAnswers = triviaBoardAnswers;
	}
	public TriviaQuestionList getTriviaQuestionList() {
		return triviaQuestionList;
	}
	public void setTriviaQuestionList(TriviaQuestionList triviaQuestionList) {
		this.triviaQuestionList = triviaQuestionList;
	}

}
