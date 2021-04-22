package com.manager;

import java.io.IOException;
import java.util.List;

import org.springframework.context.annotation.Scope;

import com.flolive.models.DataFromOpentDbService;
import com.flolive.models.TriviaAnswers;
import com.flolive.models.TriviaBoardAnswers;

@Scope("session")
public class GameManager {
	
	public boolean checkAnswer(TriviaBoardAnswers triviaBoardAnswers,
			int boardId, int questionId,int answerId) {
		List<TriviaAnswers> list = triviaBoardAnswers.getMap().get(boardId);
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
