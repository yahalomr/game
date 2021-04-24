package com.flolive.question.provider;

import java.io.IOException;

import com.flolive.models.GameManagerObject;

public interface IQuestionProvider {

	public GameManagerObject getRandomQuestions(int boardId) throws IOException ;
}
