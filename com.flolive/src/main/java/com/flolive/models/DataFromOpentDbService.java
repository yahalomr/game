package com.flolive.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;

@Scope("prototype")
public class DataFromOpentDbService {
	private List<DataFromOpentTriviaQuestion> triviaListQuestions;

	public DataFromOpentDbService() {
		triviaListQuestions = new ArrayList<DataFromOpentTriviaQuestion>();
	}
	public List<DataFromOpentTriviaQuestion> getTriviaListQuestions() {
		return triviaListQuestions;
	}

	public void setTriviaListQuestions(List<DataFromOpentTriviaQuestion> triviaListQuestions) {
		this.triviaListQuestions = triviaListQuestions;
	}
}
