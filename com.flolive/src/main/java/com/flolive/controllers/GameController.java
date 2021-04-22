package com.flolive.controllers;

//import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flolive.models.AnswerRequest;
import com.flolive.models.AnswerResponse;
import com.flolive.models.Competitive;
import com.flolive.models.Competitives;
import com.flolive.models.TriviaQuestion;
import com.flolive.service.TriviaServiceImpl;

//TODO chane int -> to long
@RestController
@RequestMapping("api/game")
public class GameController {
	
	private TriviaServiceImpl triviaService;
	private Competitives usersInTheGame = new Competitives();

	GameController(){
		this.triviaService = new TriviaServiceImpl();
		for(int i =0 ;i<20;i++)
			createGameBoards(i);
		
	}
	private void createGameBoards(int boardId) {
		try {
			this.triviaService.createQuestionBoard(boardId);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	//TODO -DELETE
	@CrossOrigin
	@GetMapping("/competitive")
	public List<Competitive> getCompetitive(@RequestParam int boardId) {
		return usersInTheGame.getUserNameList().get(boardId);
	}
	
	@CrossOrigin
	@GetMapping("/userName")
	public String add(@RequestParam String userName, @RequestParam int boardId) {
		usersInTheGame.addUserName(boardId ,userName);
	//	scoreUsers.addCompetitive(Integer.valueOf(gameId) ,userName);
		return userName;
		
	  }
	
	 @CrossOrigin
	 @PostMapping("/answerQuestion")
	 AnswerResponse answerQuestion(@RequestBody AnswerRequest questionRequest) {
		 AnswerResponse questionResponse = new AnswerResponse();
		 int boardId = questionRequest.getBoardId();
		int questionId = questionRequest.getQuestionId();
		int answerId = questionRequest.getAnswerId();
		questionResponse.setAnswerStatus(this.triviaService.getStatus(boardId, questionId, answerId));
		 questionResponse.setPointsEarned(this.triviaService.earnedPoint(boardId, questionId, answerId));
		 usersInTheGame.updateScoreOfUserName(boardId, questionRequest.getUserName(), questionResponse.getPointsEarned());
		 return questionResponse;
	  }
	 

	@GetMapping("/board/{boardId}")
	public List<Competitive> getLeaderBoard(@PathVariable("boardId") int id) {
		return usersInTheGame.getUserNameList().get(id);
	}
	
	@GetMapping("/{boardId}/question/{questionId}")
	public TriviaQuestion getQuestions(@PathVariable("questionId") int id ,
			@PathVariable("boardId") int boardId) {
		return this.triviaService.getQuestions(boardId).getList().get(id);//.getMap().get(gameId).getList().get(id);
	}
	

}
