package com.flolive.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
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
import com.flolive.models.BoardRequest;
import com.flolive.models.Competitive;
import com.flolive.models.Competitives;
import com.flolive.models.TriviaQuestion;
import com.flolive.models.TriviaQuestionList;
import com.flolive.service.TriviaServiceImpl;

@RestController
@RequestMapping("api/game")
public class GameController {
	
	private TriviaServiceImpl triviaService;
	private Competitives usersInTheGame = new Competitives();

	GameController(){
		this.triviaService = new TriviaServiceImpl();
		for(int i =0 ;i<20;i++)
			try {
				createGameBoards(i);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	@CrossOrigin
	@PostMapping("/new/board")
	ResponseEntity<String> createBoard(@RequestBody BoardRequest boardRequest) {
		try {
			boolean isCreated = createGameBoards(boardRequest.getBoardId());
			if(isCreated) {
				return ResponseEntity.ok("Create new board");
			}else {
				return ResponseEntity.badRequest().body("failed in creation a new board");
			}
		} catch (IOException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	 }
	
	private boolean createGameBoards(int boardId) throws IOException {
		return this.triviaService.createQuestionBoard(boardId);
	}

	@CrossOrigin
	@GetMapping("/userName")
	public String add(@RequestParam String userName, @RequestParam int boardId) {
		usersInTheGame.addUserName(boardId ,userName);
		return userName;
		
	  }
	
	 @CrossOrigin
	 @PostMapping("/answerQuestion")
	 ResponseEntity<AnswerResponse> answerQuestion(@RequestBody AnswerRequest questionRequest) {
		 AnswerResponse questionResponse = new AnswerResponse();
		 try {
			 int boardId = questionRequest.getBoardId();
			 int questionId = questionRequest.getQuestionId();
			 int answerId = questionRequest.getAnswerId();
			 questionResponse.setAnswerStatus(this.triviaService.getStatus(boardId, questionId, answerId));
			 questionResponse.setPointsEarned(this.triviaService.earnedPoint(boardId, questionId, answerId));
			 usersInTheGame.updateScoreOfUserName(boardId, questionRequest.getUserName(), questionResponse.getPointsEarned());
			 return ResponseEntity.ok(questionResponse);
		 }catch (Exception e) {
			 return ResponseEntity.badRequest().body(questionResponse);
		}
		 
	  }
	 

	@GetMapping("/board/{boardId}")
	public List<Competitive> getLeaderBoard(@PathVariable("boardId") int id) {
		return usersInTheGame.getUserNameList().get(id);
	}
	
	@GetMapping("/{boardId}/question/{questionId}")
	public ResponseEntity<TriviaQuestion> getQuestions(@PathVariable("questionId") int id ,
			@PathVariable("boardId") int boardId) {
		TriviaQuestion triviaQuestion = null;
		TriviaQuestionList triviaQuestionList =  this.triviaService.getQuestions(boardId);
		if(triviaQuestionList != null) {
			triviaQuestion =triviaQuestionList.getList().get(id);
			if(triviaQuestion !=null) {
				return ResponseEntity.ok(triviaQuestion);
			}
		}
		return ResponseEntity.badRequest().body(triviaQuestion);
	}
	

}
