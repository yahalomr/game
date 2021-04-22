package com.flolive.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.flolive.models.DataFromOpentDbService;
import com.flolive.models.DataFromOpentTriviaQuestion;
import com.flolive.models.Question;
import com.flolive.models.TriviaAnswers;
import com.flolive.models.TriviaBoardAnswers;
import com.flolive.models.TriviaQuestion;
import com.flolive.models.TriviaQuestionGame;
import com.flolive.models.TriviaQuestionList;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.manager.GameManager;
import com.manager.Parser;

public class TriviaServiceImpl{

	private GameManager gameManager = new GameManager();
	private Parser parser = new Parser();

	public boolean checkAnswer(int boardId, int questionId,int answerId) {
		return gameManager.checkAnswer(this.parser.getTriviaBoardAnswers(),
				boardId, questionId,answerId);
	}
	

	public int earnedPoint(int boardId, int questionId,int answerId) {
	
		return gameManager.earnedPoint(this.parser.getTriviaBoardAnswers(),
				boardId, questionId, answerId);		
	}
	
	public void createQuestionBoard(int boardId) throws IOException {
		DataFromOpentDbService data = getRandomQuestions(); 
		parser.parse(data, boardId);
	}
	
	public TriviaQuestionGame getQuestions() {
		return this.parser.getTriviaQuestionGame();//.getTriviaQuestionGame().getMap().get(gameId).getList().get(id);
	}
	
	
	

	public int getStatus(int boardId, int questionId,int answerId) {
		return gameManager.getStatus(this.parser.getTriviaBoardAnswers(),
				boardId, questionId, answerId);	
	}
	
//	
//	public DataFromOpentDbService createTriviaListQuestion() throws IOException {
//		return getRandomQuestions();
//		
//	}	
	
	public DataFromOpentDbService getRandomQuestions() throws IOException {
		
		DataFromOpentDbService triviaListQuestions = new DataFromOpentDbService();
		
		URL url = new URL("https://opentdb.com/api.php?amount=10&type=multiple");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		String response;
		
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		Gson json = new Gson(); 
		while ((response = in.readLine()) != null) {
		JsonElement element = json.fromJson (response, JsonElement.class); 
			JsonObject jsonObj = element.getAsJsonObject(); 
			JsonArray arr =  (JsonArray) jsonObj.get("results");
			for(int i = 0 ; i<arr.size() ; i++) {
				JsonObject data = (JsonObject) arr.get(i);
				
				JsonElement question=  data.get("question") != JsonNull.INSTANCE ? data.get("question") : null;
				JsonElement correctAnswer=  data.get("correct_answer") != JsonNull.INSTANCE ? data.get("correct_answer") : null;
				String correctAns = correctAnswer!=null?correctAnswer.getAsString():"";
				
				JsonArray inCorrectAnswer=  (JsonArray) data.get("incorrect_answers"); 
				List<String> inCorrectAnswers= new ArrayList<String>();
				if(inCorrectAnswer!=null ) {
					for(int j =0; j<inCorrectAnswer.size();j++) {
						JsonElement ans = inCorrectAnswer.get(j);
						inCorrectAnswers.add(ans.getAsString());
					}
				}
				DataFromOpentTriviaQuestion triviaQuestion = new DataFromOpentTriviaQuestion(inCorrectAnswers,correctAns,question.getAsString(),i);
				triviaListQuestions.getTriviaListQuestions().add(triviaQuestion);
			}
			
		}
		in.close();
		return triviaListQuestions;
	}

	
}
