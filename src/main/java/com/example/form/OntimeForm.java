package com.example.form;

public class OntimeForm {
	
	private Integer id;
	private static Integer userId;
	private static String standardStartTime;
	private static String standardEndTime;
//	private static String breakTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public static Integer getUserId() {
		return userId;
	}
	public static void setUserId(Integer userId) {
		OntimeForm.userId = userId;
	}
	public static String getStandardStartTime() {
		return standardStartTime;
	}
	public static void setStandardStartTime(String standardStartTime) {
		OntimeForm.standardStartTime = standardStartTime;
	}
	public static String getStandardEndTime() {
		return standardEndTime;
	}
	public static void setStandardEndTime(String standardEndTime) {
		OntimeForm.standardEndTime = standardEndTime;
	}
//	public static String getBreakTime() {
//		return breakTime;
//	}
//	public static void setBreakTime(String breakTime) {
//		OntimeForm.breakTime = breakTime;
//	}
	@Override
	public String toString() {
		return "OntimeForm [id=" + id + "]";
	}
	
	

}
