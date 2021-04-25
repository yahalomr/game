package com.flolive.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class Competitives {
	
 	private Map<Integer, List<Competitive>> userNameList;

	public Competitives() {
		userNameList = new HashMap<Integer, List<Competitive>>();
	}

	public boolean addUserName(int boardId, String userName) {
		Competitive competitive = new Competitive(0, userName); 
		List<Competitive> list = userNameList.get(boardId);
		if(list!=null) {
			if( isUserNameExists(userName, list)) {
				return false;
			}
			else {
				list.add(competitive);
			}
		}else {
			list =new ArrayList<Competitive>();
			list.add(competitive);
			this.userNameList.put(boardId,list);
		}
		return true;
	}

	private boolean isUserNameExists(String userName, List<Competitive> list) {
		for(Competitive comp : list) {
			if(userName.equals(comp.getUser().getUserName())) {
				return true;
			}
			
		}
		return false;
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
