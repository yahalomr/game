package com.flolive.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;

@Scope("singelton")
public class TriviaBoardAnswers {

	private Map<Integer,List<TriviaAnswers>> map;

	public TriviaBoardAnswers() {
		this.map  = new HashMap<Integer, List<TriviaAnswers>>();
	}
	public Map<Integer,List<TriviaAnswers>> getMap() {
		return map;
	}

}
