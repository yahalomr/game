package com.manager;

import java.util.ArrayList;
import java.util.List;

import com.flolive.models.DataFromOpentDbService;
import com.flolive.models.DataFromOpentTriviaQuestion;
import com.flolive.models.GameManagerObject;
import com.flolive.models.TriviaAnswers;
import com.flolive.models.TriviaBoardAnswers;
import com.flolive.models.TriviaQuestion;
import com.flolive.models.TriviaQuestionList;

public class Parser {

	private com.flolive.models.GameManagerForBoard GameManagerForBoard = new com.flolive.models.GameManagerForBoard();
	private TriviaBoardAnswers triviaBoardAnswers;
	private TriviaQuestionList triviaQuestionList;
	
	public Parser() {
		triviaBoardAnswers = new TriviaBoardAnswers();
		triviaQuestionList = new TriviaQuestionList();
	}
	
	public GameManagerObject parse(DataFromOpentDbService data, int boardId){
		
		GameManagerObject gameManagerObject = new GameManagerObject();
		TriviaQuestionList questionList = new TriviaQuestionList();
		List<TriviaAnswers> answerList = new ArrayList<TriviaAnswers>();
		for(DataFromOpentTriviaQuestion question: data.getTriviaListQuestions()) {
			populateTriviaQuestions(questionList, question);
			populateTriviaAnswers(answerList, question);
			
		}
		this.triviaBoardAnswers.getList().addAll(answerList);
		this.triviaQuestionList.setList(questionList.getList());
		
		gameManagerObject.setTriviaBoardAnswers(triviaBoardAnswers);
		gameManagerObject.setTriviaQuestionList(triviaQuestionList);
		
		return gameManagerObject;
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

	public TriviaBoardAnswers getTriviaBoardAnswers() {
		return triviaBoardAnswers;
	}

	public void setTriviaBoardAnswers(TriviaBoardAnswers triviaBoardAnswers) {
		this.triviaBoardAnswers = triviaBoardAnswers;
	}

}
