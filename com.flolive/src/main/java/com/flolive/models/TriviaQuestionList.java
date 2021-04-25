package com.flolive.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;

@Scope("prototype")
public class TriviaQuestionList {

	private List<TriviaQuestion> list;

	public TriviaQuestionList() {
		list = new ArrayList<TriviaQuestion>();
	}
	public List<TriviaQuestion> getList() {
		return list;
	}

	public void setList(List<TriviaQuestion> list) {
		this.list = list;
	}
}
