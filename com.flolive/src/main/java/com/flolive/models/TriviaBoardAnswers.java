package com.flolive.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;

//@Scope("singelton")
public class TriviaBoardAnswers {

	private List<TriviaAnswers> list;

	public TriviaBoardAnswers() {
		this.list = new ArrayList<TriviaAnswers>();
	}
	public List<TriviaAnswers> getList() {
		return list;
	}

	public void setList(List<TriviaAnswers> list) {
		this.list = list;
	}


}
