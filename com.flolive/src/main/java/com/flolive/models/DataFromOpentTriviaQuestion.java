package com.flolive.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.context.annotation.Scope;

@Scope("prototype")
public class DataFromOpentTriviaQuestion {
	
	private Question question;
	private List<Answer> answers;
	private String correctAnswer;
	private int correctAnswerId;
	
	public DataFromOpentTriviaQuestion(List<String> inCorrectAnswer,String correctAnswer, String question, int questionId) {
		answers = new ArrayList<Answer>(4);
		this.question = new Question();
		this.question.setIdx(questionId);
		this.question.setText(question);
		int randomCorrectAnswer = getRandomNumberInRange(0, inCorrectAnswer.size());
		Answer corAnswer = new Answer();
		corAnswer.setIdx(randomCorrectAnswer);
		corAnswer.setText(correctAnswer);
		//answers.put(randomCorrectAnswer, correctAnswer);
		//answers.add(answer);
		//answers.add(randomCorrectAnswer, corAnswer);
		this.setCorrectAnswerId(randomCorrectAnswer);
		
		
		int incoIdx=0;
		for(; incoIdx<randomCorrectAnswer && incoIdx<inCorrectAnswer.size();incoIdx++) {
			Answer answer = new Answer();
			answer.setIdx(incoIdx);
			answer.setText(inCorrectAnswer.get(incoIdx));
			answers.add(answer);
			
		}
		answers.add(corAnswer);
		for(; incoIdx<inCorrectAnswer.size();incoIdx++) {
			Answer answer = new Answer();
			answer.setIdx(incoIdx+1);
			answer.setText(inCorrectAnswer.get(incoIdx));
			answers.add(answer);
		}
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	//in util
    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
	public int getCorrectAnswerId() {
		return correctAnswerId;
	}
	public void setCorrectAnswerId(int correctAnswerId) {
		this.correctAnswerId = correctAnswerId;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
	
}
