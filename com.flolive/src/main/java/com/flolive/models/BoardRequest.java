package com.flolive.models;

import org.springframework.context.annotation.Scope;

@Scope("request")
public class BoardRequest {

	private int boardId;

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public int getBoardId() {
		return boardId;
	}

}
