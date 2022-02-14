package com.example.domain;

public class Ontime {
	
	/*id*/
	private Integer id;
	/*ユーザーid*/
	private Integer userId;
	/*定時（出勤）*/
	private String standardStartTime;
	/*定時（退勤）*/
	private String standardEndTime;
	/*休憩時間*/
	private String breakTime;
	
	public Ontime() {
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getStandardStartTime() {
		return standardStartTime;
	}

	public void setStandardStartTime(String standardStartTime) {
		this.standardStartTime = standardStartTime;
	}

	public String getStandardEndTime() {
		return standardEndTime;
	}

	public void setStandardEndTime(String standardEndTime) {
		this.standardEndTime = standardEndTime;
	}

	public String getBreakTime() {
		return breakTime;
	}

	public void setBreakTime(String breakTime) {
		this.breakTime = breakTime;
	}


	@Override
	public String toString() {
		return "Ontimes [id=" + id + ", userId=" + userId + ", standardStartTime=" + standardStartTime
				+ ", standardEndTime=" + standardEndTime + ", breakTime=" + breakTime + "]";
	}
	
	

	
}
