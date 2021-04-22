package com.manager;

import java.util.ArrayList;
import java.util.List;

import com.flolive.models.DataFromOpentDbService;
import com.flolive.models.DataFromOpentTriviaQuestion;
import com.flolive.models.TriviaAnswers;
import com.flolive.models.TriviaBoardAnswers;
import com.flolive.models.TriviaQuestion;
import com.flolive.models.TriviaQuestionGame;
import com.flolive.models.TriviaQuestionList;

public class Parser {

	private TriviaBoardAnswers triviaBoardAnswers;
	private TriviaQuestionGame triviaQuestionGame;
	
	public Parser() {
		triviaBoardAnswers = new TriviaBoardAnswers();
		triviaQuestionGame = new TriviaQuestionGame();
	}
	
	public void parse(DataFromOpentDbService data, int boardId){
		TriviaQuestionList questionList = new TriviaQuestionList();
		List<TriviaAnswers> answerList = new ArrayList<TriviaAnswers>();
		for(DataFromOpentTriviaQuestion question: data.getTriviaListQuestions()) {
			populateTriviaQuestions(questionList, question);
			populateTriviaAnswers(answerList, question);
			
		}
		this.triviaBoardAnswers.getMap().put(boardId, answerList);
		this.triviaQuestionGame.getMap().put(boardId, questionList);
	}
	
	private void populateTriviaAnswers(List<TriviaAnswers> answerList, DataFromOpentTriviaQuestion question) {
		TriviaAnswers triviaAnswers	= new TriviaAnswers();
		triviaAnswers.setQuestionId(question.getQuestion().getIdx());
		triviaAnswers.setCorrectAnswerID(question.getCorrectAnswerId());
		answerList.add(triviaAnswers);
	}

	private void populateTriviaQuestions(TriviaQuestionList questionList, DataFromOpentTriviaQuestion question) {
		TriviaQuestion triviaQuestion = new TriviaQuestion();
		triviaQuestion.setAnswers(question.getAnswers());
		triviaQuestion.setQuestion(question.getQuestion());
		questionList.getList().add(triviaQuestion);
	}

//	
//	public Object parse(Object Obj) {
//		return null;
//	}
//	

	public TriviaBoardAnswers getTriviaBoardAnswers() {
		return triviaBoardAnswers;
	}

	public void setTriviaBoardAnswers(TriviaBoardAnswers triviaBoardAnswers) {
		this.triviaBoardAnswers = triviaBoardAnswers;
	}

	public TriviaQuestionGame getTriviaQuestionGame() {
		return triviaQuestionGame;
	}

	public void setTriviaQuestionGame(TriviaQuestionGame triviaQuestionGame) {
		this.triviaQuestionGame = triviaQuestionGame;
	}
	
}
