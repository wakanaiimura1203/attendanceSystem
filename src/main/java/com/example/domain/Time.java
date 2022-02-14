package com.example.domain;

import java.sql.Date;

public class Time {

	/* id */
	private Integer id;
	/* ユーザーid Userのidと紐付く */
	private Integer userId;
	/* 日付 */
	private Date dateOfDay;
	/* 勤務開始時刻 */
	private String inputStartTime;
	/* 退勤時刻 */
	private String inputEndTime;

	/* 引数なしのコンストラクタ */
	public Time() {
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

	public Date getDateOfDay() {
		return dateOfDay;
	}

	public void setDateOfDay(Date dateOfDay) {
		this.dateOfDay = dateOfDay;
	}

	public String getInputStartTime() {
		return inputStartTime;
	}

	public void setInputStartTime(String inputStartTime) {
		this.inputStartTime = inputStartTime;
	}

	public String getInputEndTime() {
		return inputEndTime;
	}

	public void setInputEndTime(String inputEndTime) {
		this.inputEndTime = inputEndTime;
	}

	@Override
	public String toString() {
		return "Time [id=" + id + ", userId=" + userId + ", dateOfDay=" + dateOfDay + ", inputStartTime="
				+ inputStartTime + ", inputEndTime=" + inputEndTime + "]";
	}

	


}
