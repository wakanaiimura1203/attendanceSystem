package com.example.form;

import java.util.List;

public class MonthlyForm {
	
	/*id*/
	private Integer id;
	/*ユーザーid*/
	private Integer userId;
	/*年*/
	private Integer year;
	/*年月*/
	private String yearMonth;
	/*月日*/
	private String monthDate;
	/*曜日*/
	private String dayOfWeek;
	/*休憩時間*/
	private String breakTime;
	/*残業時間*/
	private String overTime;
	/*コメント*/
	private String comment;
	
	private List<String> dayList;
	
	public List<String> getDayList() {
		return dayList;
	}
	public void setDayList(List<String> dayList) {
		this.dayList = dayList;
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
	public String yearMonth() {
		return yearMonth;
	}
	public void setYearMonth(String yearMonth) {
		this.yearMonth = yearMonth;
	}
	public String getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public String getBreakTime() {
		return breakTime;
	}
	public void setBreakTime(String breakTime) {
		this.breakTime = breakTime;
	}
	public String getOverTime() {
		return overTime;
	}
	public void setOverTime(String overTime) {
		this.overTime = overTime;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public String getMonthDate() {
		return monthDate;
	}
	public void setMonthDate(String monthDate) {
		this.monthDate = monthDate;
	}
	
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public String getYearMonth() {
		return yearMonth;
	}
	@Override
	public String toString() {
		return "MonthlyForm [id=" + id + ", userId=" + userId + ", year=" + year + ", yearMonth=" + yearMonth
				+ ", monthDate=" + monthDate + ", dayOfWeek=" + dayOfWeek + ", breakTime=" + breakTime + ", overTime="
				+ overTime + ", comment=" + comment + ", dayList=" + dayList + "]";
	}

	
}
