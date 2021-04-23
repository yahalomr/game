package com.flolive.service;

import com.flolive.models.TriviaQuestionList;

public interface TriviaService {

	public TriviaQuestionList getQuestions(int boardId);
}
