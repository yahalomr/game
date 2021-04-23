package com.manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.flolive.models.Answer;
import com.flolive.models.GameManagerObject;
import com.flolive.models.Question;
import com.flolive.models.TriviaAnswers;
import com.flolive.models.TriviaBoardAnswers;
import com.flolive.models.TriviaQuestion;
import com.flolive.models.TriviaQuestionList;
import com.flolive.question.provider.IQuestionProvider;

public class QuestionProviderMock implements IQuestionProvider {

	@Override
	public GameManagerObject getRandomQuestions(int boardId) throws IOException {
		
		GameManagerObject gameManagerObject =new GameManagerObject();
		TriviaBoardAnswers triviaBoard = new TriviaBoardAnswers();
		List<TriviaAnswers> triviaAnswer = new ArrayList<TriviaAnswers>();
		TriviaAnswers answers =new TriviaAnswers();
		answers.setCorrectAnswerID(1);
		answers.setQuestionId(0);
		triviaAnswer.add(answers );
		triviaBoard.setList(triviaAnswer );
		gameManagerObject.setTriviaBoardAnswers(triviaBoard );
		TriviaQuestionList questionList = new TriviaQuestionList();
		TriviaQuestion triviaQuestion =new TriviaQuestion();
		createQuestion(triviaQuestion);
		List<Answer> answersList = createAnswerList();
		triviaQuestion.setAnswers(answersList );
		questionList.getList().add(triviaQuestion );
		gameManagerObject.setTriviaQuestionList(questionList );
		return gameManagerObject;
	}
	
	private void createQuestion(TriviaQuestion triviaQuestion) {
		Question question = new Question();
		question.setIdx(0);
		question.setText("rrrr");
		triviaQuestion.setQuestion(question );
	}

	private List<Answer> createAnswerList() {
		List<Answer> answersList = new ArrayList<Answer>();
		Answer ans =new Answer();
		ans.setIdx(0);
		ans.setText("aa");
		answersList.add(ans );
		ans =new Answer();
		ans.setIdx(1);
		ans.setText("BB");
		answersList.add(ans );
	    ans =new Answer();
		ans.setIdx(2);
		ans.setText("cc");
		answersList.add(ans );
		ans =new Answer();
		ans.setIdx(4);
		ans.setText("dd");
		answersList.add(ans );
		return answersList;
	}


}
