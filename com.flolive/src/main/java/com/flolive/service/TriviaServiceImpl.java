package com.flolive.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.flolive.models.GameManagerObject;
import com.flolive.models.TriviaQuestionList;
import com.flolive.question.provider.QuestionProvider;
import com.manager.GameManager;

/**
 * service of the game
 */
@Service
public class TriviaServiceImpl implements TriviaService{

	private GameManager gameManager;

	@Autowired
	public TriviaServiceImpl(GameManager gameManager) {
		this.gameManager = gameManager;//new GameManager(new QuestionProvider());
	}

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
