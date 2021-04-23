package com.flolive.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Scope("singleton")
@Component
public class Competitives {
	
 	private Map<Integer, List<Competitive>> userNameList;

	public Competitives() {
		userNameList = new HashMap<Integer, List<Competitive>>();
	}

	public void addUserName(int boardId, String userName) {
		Competitive competitive = new Competitive(0, userName); 
		List<Competitive> list = userNameList.get(boardId);
		if(list!=null) {
			list.add(competitive);
		}else {
			list =new ArrayList<Competitive>();
			list.add(competitive);
			this.userNameList.put(boardId,list);
		}
	}
	
	public void updateScoreOfUserName(int boardId, String userName,int score ) {
		
		List<Competitive> list = userNameList.get(boardId);
		if(list!=null) {
			for(Competitive comp:list) {
				if(userName.equals(comp.getUser().getUserName())) {
					comp.setScore(comp.getScore()+score);
				}
			}
		}
	}

	public Map<Integer, List<Competitive>> getUserNameList() {
		return userNameList;
	}

}
