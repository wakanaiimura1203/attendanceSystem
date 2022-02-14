package com.example.domain;

import java.util.List;

public class User {

	/* ユーザーid */
	private Integer id;
	/* 名前 */
	private String name;
	/* メールアドレス */
	private String email;
	/* パスワード */
	private String password;
	/* 電話番号 */
	private String telephone;
	/* ステータス */
	private String status;
	/* 勤怠情報リスト */
	private List<Time> timeList;

	/* 引数なしのコンストラクタ */
	public User() {
	}
	

	public User(Integer id, String name, String email, String password, String telephone, String status,
			List<Time> timeList) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.telephone = telephone;
		this.status = status;
		this.timeList = timeList;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Time> getTimeList() {
		return timeList;
	}

	public void setTimeList(List<Time> timeList) {
		this.timeList = timeList;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", telephone="
				+ telephone + ", status=" + status + ", timeList=" + timeList + "]";
	}


}
