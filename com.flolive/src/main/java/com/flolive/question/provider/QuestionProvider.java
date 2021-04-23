package com.flolive.question.provider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.flolive.models.DataFromOpentDbService;
import com.flolive.models.DataFromOpentTriviaQuestion;
import com.flolive.models.FooFormatter;
import com.flolive.models.GameManagerObject;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.manager.GameManagerParser;

/**
 * QuestionProvider - call to opentdb API to get question for the game
 */
@Component
public class QuestionProvider implements IQuestionProvider{

	
	private GameManagerParser parser;//= new GameManagerParser();
	
	 @Autowired
	 public QuestionProvider(GameManagerParser parser) {
		 this.parser = parser;
	 }

	

	/**
	 * get random question from opentdb API
	 * and return GameManagerObject object
	 */
	@Override
	public GameManagerObject getRandomQuestions(int boardId) throws IOException {
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
		return parser.parse(triviaListQuestions, boardId);
	}

}
