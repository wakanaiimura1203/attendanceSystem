package com.example.form;

import java.io.Serializable;
import java.sql.Date;

public class TimeForm implements Serializable {

	private static final long serialVersionUID = 1L;

	/* id */
	private static Integer id;
	/* ユーザーid */
	private static Integer userId;
	/* 日付 */
	private Date dateOfDay;
	/* 出勤時刻 */
	private static String inputStartTime;
	/* 退勤時刻 */
	private static String inputEndTime;
	
	public static Integer getId() {
		return id;
	}
	public static void setId(Integer id) {
		TimeForm.id = id;
	}
	public static Integer getUserId() {
		return userId;
	}
	public static void setUserId(Integer userId) {
		TimeForm.userId = userId;
	}
	public Date getDateOfDay() {
		return dateOfDay;
	}
	public void setDateOfDay(Date dateOfDay) {
		this.dateOfDay = dateOfDay;
	}
	public static String getInputStartTime() {
		return inputStartTime;
	}
	public static void setInputStartTime(String inputStartTime) {
		TimeForm.inputStartTime = inputStartTime;
	}
	public static String getInputEndTime() {
		return inputEndTime;
	}
	public static void setInputEndTime(String inputEndTime) {
		TimeForm.inputEndTime = inputEndTime;
	}
	
	@Override
	public String toString() {
		return "TimeForm [dateOfDay=" + dateOfDay + "]";
	}

	

}
