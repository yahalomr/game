package com.flolive.models;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;

@Scope("singleton")
public class TriviaQuestionGame {
	
	private Map<Integer, TriviaQuestionList> map;

	public TriviaQuestionGame(){
		map = new HashMap<Integer, TriviaQuestionList>();
	}
	
	public void addTriviaList(int gameId, TriviaQuestionList list) {
		map.put(gameId, list);
		
	}
	public Map<Integer, TriviaQuestionList> getMap() {
		return map;
	}

	public void setMap(Map<Integer, TriviaQuestionList> map) {
		this.map = map;
	}
}
