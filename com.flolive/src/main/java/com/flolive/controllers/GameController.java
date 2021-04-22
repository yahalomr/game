package com.flolive.controllers;

//import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.ws.Response;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flolive.models.AnswerRequest;
import com.flolive.models.AnswerResponse;
import com.flolive.models.Competitive;
import com.flolive.models.Competitives;
import com.flolive.models.DataFromOpentDbService;
import com.flolive.models.DataFromOpentTriviaQuestion;
import com.flolive.models.TriviaQuestion;
import com.flolive.models.TriviaQuestionGame;
import com.flolive.models.TriviaQuestionList;
import com.flolive.service.TriviaService;
import com.flolive.service.TriviaServiceImpl;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;

//TODO chane int -> to long
@RestController
@RequestMapping("api/game")
public class GameController {
	
	private TriviaServiceImpl triviaService;
	private Competitives usersInTheGame = new Competitives();
//	private TriviaQuestionGame triviaQuestionGame = new TriviaQuestionGame();

	GameController(){
		this.triviaService = new TriviaServiceImpl();
		for(int i =0 ;i<20;i++)
			createGameBoards(i);
		
	}
	private void createGameBoards(int boardId) {
		try {
			this.triviaService.createQuestionBoard(boardId);
		//	triviaQuestionGame.getMap().put(boardId, triviaListQuestions);
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
	
	@GetMapping("/{gameId}/question/{questionId}")
	public TriviaQuestion getQuestions(@PathVariable("questionId") int id ,
			@PathVariable("gameId") int gameId) {
		return this.triviaService.getQuestions().getMap().get(gameId).getList().get(id);
	}
	

}
