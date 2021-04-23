package com.manager;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.flolive.consts.GameConsts;
import com.flolive.models.GameManagerForBoard;
import com.flolive.models.GameManagerObject;
import com.flolive.models.TriviaAnswers;
import com.flolive.question.provider.IQuestionProvider;

/**
 * manager of the game
 */
@Component
public class GameManager implements GameConsts {

	private GameManagerForBoard gameManagerForBoard;
	private IQuestionProvider questionProvider;

	@Autowired
	public GameManager(IQuestionProvider questionProvider,
			GameManagerForBoard gameManagerForBoard) {
		this.questionProvider = questionProvider;
		this.gameManagerForBoard = gameManagerForBoard;
	}
	
	public GameManagerForBoard getGameManagerForBoard() {
		return gameManagerForBoard;
	}

	public void setGameManagerForBoard(GameManagerForBoard gameManagerForBoard) {
		this.gameManagerForBoard = gameManagerForBoard;
	}

	public boolean createQuestionBoard(int boardId) throws IOException{
		if(gameManagerForBoard.getMap().get(boardId)==null) {
			GameManagerObject gameManagerObject = questionProvider.getRandomQuestions(boardId);
			gameManagerForBoard.getMap().put(boardId, gameManagerObject);
			return true;
		}
		return false;
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

	 /** get The point of the answer question 
	 * @param boardId
	 * @param questionId
	 * @param answerId
	 * @return CORRECT_ANSWER_POINTS - for correct answer
	 * IN_CORRECT_ANSWER_POINTS - for incorrect answer 
	 */
	public int earnedPoint(int boardId, int questionId,int answerId) {
		if(checkAnswer(boardId, questionId, answerId)) {
			return CORRECT_ANSWER_POINTS;
		}
		return IN_CORRECT_ANSWER_POINTS;
		
	}
	
	/**
	 * get The status of the answer question
	 * @param boardId
	 * @param questionId
	 * @param answerId
	 * @return CORRECT - for correct answer
	 * IN_CORRECT - for incorrect answer 
	 */
	public int getStatus(int boardId, int questionId,int answerId) {
		if(checkAnswer(boardId, questionId, answerId)) {
			return CORRECT;
		}
		return IN_CORRECT;
		
	}

}
