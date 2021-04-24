package com.flolive.models;

import org.springframework.stereotype.Component;

@Component
public class Answer {

	private int idx;
	private String text;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

}
