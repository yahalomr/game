package com.manager;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.flolive.consts.GameConsts;
import com.flolive.models.GameManagerForBoard;
import com.flolive.question.provider.IQuestionProvider;

class GameManagerTest implements GameConsts{
//
//	@Autowired
//	GameManager gameManager;
//	
//
//	public void setUp() {
//		GameManagerForBoard gameManagerBoard  = new GameManagerForBoard();
//		IQuestionProvider iquestion = new QuestionProviderMock();
//		gameManager=new GameManager(iquestion );
//		gameManager.setGameManagerForBoard(gameManagerBoard );
//	}
//	
//	@Test
//	void createBoard() {
//		setUp();
//		boolean isCreated;
//		try {
//			isCreated = gameManager.createQuestionBoard(12);
//			assertEquals(isCreated, true);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//	}
//	
//	@Test
//	void earnedPoint_wrongAnswer() {	
//			setUp();
//			try {
//				gameManager.createQuestionBoard(0);
//				int earned = gameManager.earnedPoint(0, 0, 2);
//				assertEquals(earned, IN_CORRECT_ANSWER_POINTS);
//			
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		
//	}
//	
//	@Test
//	void earnedPoint_correctAnswer() {	
//			setUp();
//			try {
//				gameManager.createQuestionBoard(0);
//				int earned = gameManager.earnedPoint(0, 0, 1);
//				assertEquals(earned, CORRECT_ANSWER_POINTS);
//			
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		
//	}
//	
//	@Test
//	void earnedPoint_boardNotExists() {	
//			setUp();
//			try {
//				gameManager.createQuestionBoard(0);
//				int earned = gameManager.earnedPoint(1, 0, 1);
//				assertEquals(earned, IN_CORRECT_ANSWER_POINTS);
//			
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		
//	}
//	
//	
//	@Test
//	void getStatus_wrongAnswer() {	
//			setUp();
//			try {
//				gameManager.createQuestionBoard(0);
//				int earned = gameManager.getStatus(0, 0, 2);
//				assertEquals(earned, IN_CORRECT);
//			
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		
//	}
//	
//	@Test
//	void getStatus_correctAnswer() {	
//			setUp();
//			try {
//				gameManager.createQuestionBoard(0);
//				int earned = gameManager.getStatus(0, 0, 1);
//				assertEquals(earned, CORRECT);
//			
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		
//	}
//	
//	@Test
//	void getStatus_boardNotExists() {	
//			setUp();
//			try {
//				gameManager.createQuestionBoard(0);
//				int earned = gameManager.getStatus(1, 0, 1);
//				assertEquals(earned, IN_CORRECT);
//			
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		
//	}
//
//	
	
}
