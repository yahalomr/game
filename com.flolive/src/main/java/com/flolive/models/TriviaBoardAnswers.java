package com.flolive.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
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
