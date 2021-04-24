package com.flolive.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

//@Scope("singelton")
@Component
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
