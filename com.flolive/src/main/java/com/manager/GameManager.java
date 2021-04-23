package com.manager;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.flolive.consts.GameConsts;
import com.flolive.models.GameManagerForBoard;
import com.flolive.models.GameManagerObject;
import com.flolive.models.TriviaAnswers;
import com.flolive.question.provider.IQuestionProvider;

@Scope("singelton")
public class GameManager implements GameConsts {

	private GameManagerForBoard gameManagerForBoard;
	public GameManagerForBoard getGameManagerForBoard() {
		return gameManagerForBoard;
	}

	public void setGameManagerForBoard(GameManagerForBoard gameManagerForBoard) {
		this.gameManagerForBoard = gameManagerForBoard;
	}


	private IQuestionProvider questionProvider;

	public boolean createQuestionBoard(int boardId) throws IOException{
		if(gameManagerForBoard.getMap().get(boardId)==null) {
			GameManagerObject gameManagerObject = questionProvider.getRandomQuestions(boardId);
			gameManagerForBoard.getMap().put(boardId, gameManagerObject);
			return true;
		}
		return false;
	}
	
	@Autowired
	public GameManager(IQuestionProvider questionProvider) {
		this.questionProvider = questionProvider;
		this.gameManagerForBoard = new GameManagerForBoard();
	}
	
	private boolean checkAnswer(
			int boardId, int questionId,int answerId) {
		if(isBoardExists(boardId)) {
			List<TriviaAnswers> list = gameManagerForBoard.getMap().get(boardId).getTriviaBoardAnswers().getList();
			for(TriviaAnswers triviaAnswer: list) {
				if(triviaAnswer.getQuestionId()==questionId) {
					if(triviaAnswer.getCorrectAnswerID() == answerId) {
						return true;
					}else {
						return false;
					}
				
				}
			}
		}
		return false;
	}

	private boolean isBoardExists(int boardId) {
		return gameManagerForBoard.getMap().get(boardId)!=null;
	}

	public int earnedPoint(int boardId, int questionId,int answerId) {
		if(checkAnswer(boardId, questionId, answerId)) {
			return CORRECT_ANSWER_POINTS;
		}
		return IN_CORRECT_ANSWER_POINTS;
		
	}
	

	public int getStatus(int boardId, int questionId,int answerId) {
		if(checkAnswer(boardId, questionId, answerId)) {
			return CORRECT;
		}
		return IN_CORRECT;
		
	}

}
