package com.flolive.service;

import java.io.IOException;

import com.flolive.models.DataFromOpentDbService;

public abstract class TriviaService {

	public abstract DataFromOpentDbService createTriviaListQuestion(int boardId) throws IOException;

	public DataFromOpentDbService createTriviaListQuestion() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}
}
