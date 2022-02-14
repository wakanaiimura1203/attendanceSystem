package com.example.form;

import java.io.Serializable;

/**
 * @author shirayamawakana
 *退勤ボタン押下時に送られてくる値のフォームクラス
 */

public class EndTimeForm implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/*退勤時刻*/
	private String endTime;
	

	public EndTimeForm(String endTime) {
		super();
		this.endTime = endTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "EndTimeForm [endTime=" + endTime + "]";
	}
	
	

}
