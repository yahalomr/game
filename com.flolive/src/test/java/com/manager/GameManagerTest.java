package com.manager;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.flolive.consts.GameConsts;
import com.flolive.models.GameManagerForBoard;

class GameManagerTest implements GameConsts{

	private GameManager gameManager = 
	     new GameManager(new QuestionProviderMock(), new GameManagerForBoard());
	
	@Test
	void createBoard() {
		boolean isCreated;
		try {
			isCreated = gameManager.createQuestionBoard(12);
			assertEquals(isCreated, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	void earnedPoint_wrongAnswer() {	
//			setUp();
			try {
				gameManager.createQuestionBoard(0);
				int earned = gameManager.earnedPoint(0, 0, 2);
				assertEquals(earned, IN_CORRECT_ANSWER_POINTS);
			
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}
	
	@Test
	void earnedPoint_correctAnswer() {	
			try {
				gameManager.createQuestionBoard(0);
				int earned = gameManager.earnedPoint(0, 0, 1);
				assertEquals(earned, CORRECT_ANSWER_POINTS);
			
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}
	
	@Test
	void earnedPoint_boardNotExists() {	
		try {
			gameManager.createQuestionBoard(0);
			int earned = gameManager.earnedPoint(1, 0, 1);
			assertEquals(earned, IN_CORRECT_ANSWER_POINTS);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	void getStatus_wrongAnswer() {	
		try {
			gameManager.createQuestionBoard(0);
			int earned = gameManager.getStatus(0, 0, 2);
			assertEquals(earned, IN_CORRECT);
		
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	@Test
	void getStatus_correctAnswer() {	
		try {
			gameManager.createQuestionBoard(0);
			int earned = gameManager.getStatus(0, 0, 1);
			assertEquals(earned, CORRECT);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	void getStatus_boardNotExists() {	
		try {
			gameManager.createQuestionBoard(0);
			int earned = gameManager.getStatus(1, 0, 1);
			assertEquals(earned, IN_CORRECT);
		
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

}
