package com.example.domain;


public class Monthly {
	
	/*id*/
	private Integer id;
	/*ユーザーid*/
	private Integer userId;
	/*年*/
	private Integer year;
	/*年月*/
	private String yearMonth;
	/*月*/
	private Integer month;
	/*日付*/
	private Integer day;
	/*曜日*/
	private String dayOfWeek;
	/*出欠状況*/
	private String attendanceStatus;
	/*開始時間*/
	private String startTime;
	/*終了時間*/
	private String endTime;
	/*休憩時間*/
	private String breakTime;
	/*残業時間*/
	private String overTime;
	/*入力状況*/
	private String inputStatus;
	/*コメント*/
	private String comment;
	
	private Time time;

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

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getYearMonth() {
		return yearMonth;
	}

	public void setYearMonth(String yearMonth) {
		this.yearMonth = yearMonth;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public String getAttendanceStatus() {
		return attendanceStatus;
	}

	public void setAttendanceStatus(String attendanceStatus) {
		this.attendanceStatus = attendanceStatus;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
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

	public String getInputStatus() {
		return inputStatus;
	}

	public void setInputStatus(String inputStatus) {
		this.inputStatus = inputStatus;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Monthly [id=" + id + ", userId=" + userId + ", year=" + year + ", yearMonth=" + yearMonth + ", month="
				+ month + ", day=" + day + ", dayOfWeek=" + dayOfWeek + ", attendanceStatus=" + attendanceStatus
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", breakTime=" + breakTime + ", overTime="
				+ overTime + ", inputStatus=" + inputStatus + ", comment=" + comment + ", time=" + time + "]";
	}
	
	
	
//	/*打刻した出勤時間*/
//	private String inputStartTime;
//	/*打刻した退勤時間*/
//	private String inputEndTime;

	

	
}
