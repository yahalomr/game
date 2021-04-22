package com.flolive.service;

import java.io.IOException;

import com.flolive.models.GameManagerObject;
import com.flolive.models.TriviaQuestionList;
import com.flolive.question.provider.QuestionProvider;
import com.manager.GameManager;


public class TriviaServiceImpl{

	private GameManager gameManager = new GameManager(new QuestionProvider());
//	private Parser parser = new Parser();

	public boolean checkAnswer(int boardId, int questionId,int answerId) {
		return gameManager.checkAnswer(this.gameManager.getGameManagerForBoard().getMap().get(boardId).getTriviaBoardAnswers(),
				boardId, questionId,answerId);
	}
	

	public int earnedPoint(int boardId, int questionId,int answerId) {
	
		return gameManager.earnedPoint(this.gameManager.getGameManagerForBoard().getMap().get(boardId).getTriviaBoardAnswers(),
				boardId, questionId, answerId);		
	}
	
	public GameManagerObject createQuestionBoard(int boardId) throws IOException  {
		return this.gameManager.createQuestionBoard(boardId);
	}
	
	public TriviaQuestionList getQuestions(int boardId) {
		return this.gameManager.getGameManagerForBoard().getMap().get(boardId).getTriviaQuestionList();//();
	}
	
	
	

	public int getStatus(int boardId, int questionId,int answerId) {
		return gameManager.getStatus(this.gameManager.getGameManagerForBoard().getMap().get(boardId).getTriviaBoardAnswers(),
				boardId, questionId, answerId);	
	}
	
//	
//	public DataFromOpentDbService createTriviaListQuestion() throws IOException {
//		return getRandomQuestions();
//		
//	}	
	
	
}
