package com.flolive.service;

import java.io.IOException;

import com.flolive.models.GameManagerObject;
import com.flolive.models.TriviaQuestionList;
import com.flolive.question.provider.QuestionProvider;
import com.manager.GameManager;


public class TriviaServiceImpl{

	private GameManager gameManager;

	public TriviaServiceImpl() {
		gameManager = new GameManager(new QuestionProvider());
	}
//	
//	public boolean checkAnswer(int boardId, int questionId,int answerId) {
//		return gameManager.checkAnswer(getGameByBoardId(boardId).getTriviaBoardAnswers(),
//				boardId, questionId,answerId);
//	}
	

	public Integer earnedPoint(int boardId, int questionId,int answerId) {
		return gameManager.earnedPoint(boardId, questionId, answerId);
	}
	
	public boolean createQuestionBoard(int boardId) throws IOException  {
		return this.gameManager.createQuestionBoard(boardId);
	}
	
	public TriviaQuestionList getQuestions(int boardId) {
		if(isGameByBoardIdExists(boardId)) {
			return getGameByBoardId(boardId).getTriviaQuestionList();
		}
		return null;
		
	}


	private GameManagerObject getGameByBoardId(int boardId) {
		return this.gameManager.getGameManagerForBoard().getMap().get(boardId);
	}
	
	private boolean isGameByBoardIdExists(int boardId) {
		if(this.gameManager.getGameManagerForBoard().getMap().get(boardId)!=null) {
			return true;
		}
		return false;
	}

	public int getStatus(int boardId, int questionId,int answerId) {
		return gameManager.getStatus(
				boardId, questionId, answerId);	
	}

}
