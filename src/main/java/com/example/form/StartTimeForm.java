package com.example.form;

import java.io.Serializable;

public class StartTimeForm implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/*ユーザーid*/
	private static Integer userId;
	/*出勤ボタン*/
	private String startTime;
	
	public static Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		StartTimeForm.userId = userId;
	}
	
	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
}
