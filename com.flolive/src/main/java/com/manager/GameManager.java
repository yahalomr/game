package com.manager;

import java.io.IOException;
import java.util.List;

import org.springframework.context.annotation.Scope;

import com.flolive.models.DataFromOpentDbService;
import com.flolive.models.GameManagerForBoard;
import com.flolive.models.GameManagerObject;
import com.flolive.models.TriviaAnswers;
import com.flolive.models.TriviaBoardAnswers;
import com.flolive.question.provider.IQuestionProvider;

@Scope("singelton")
public class GameManager {

//	private GameManagerObject gameManagerObject;
	private GameManagerForBoard gameManagerForBoard;
	public GameManagerForBoard getGameManagerForBoard() {
		return gameManagerForBoard;
	}

	public void setGameManagerForBoard(GameManagerForBoard gameManagerForBoard) {
		this.gameManagerForBoard = gameManagerForBoard;
	}


	private IQuestionProvider questionProvider;

	public GameManagerObject createQuestionBoard(int boardId) throws IOException{
		GameManagerObject gameManagerObject = questionProvider.getRandomQuestions(boardId);
		gameManagerForBoard.getMap().put(boardId, gameManagerObject);
		return gameManagerObject;
	}
	
	public GameManager(IQuestionProvider questionProvider) {
		this.questionProvider = questionProvider;
		this.gameManagerForBoard = new GameManagerForBoard();
	}
	
	public boolean checkAnswer(TriviaBoardAnswers triviaBoardAnswers,
			int boardId, int questionId,int answerId) {
//		List<TriviaAnswers> list = triviaBoardAnswers.getMap().get(boardId);
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
		return false;
	}

	public int earnedPoint(TriviaBoardAnswers triviaBoardAnswers, int boardId, int questionId,int answerId) {
		if(checkAnswer(triviaBoardAnswers, boardId, questionId, answerId)) {
			return 10;
		}
		return 0;
		
	}
	

	public int getStatus(TriviaBoardAnswers triviaBoardAnswers, int boardId, int questionId,int answerId) {
		if(checkAnswer(triviaBoardAnswers, boardId, questionId, answerId)) {
			return 0;
		}
		return 1;
		
	}

}
