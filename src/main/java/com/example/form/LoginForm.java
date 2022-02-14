package com.example.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * @author shirayamawakana
 *	ログイン・ログアウト機能用のFormクラス
 */
public class LoginForm {

	/**メールアドレス*/
	@NotBlank(message="メールアドレスが未入力です。")
	@Email(message="メールアドレスの形式に誤りがあります。")
	private String email;
	/**パスワード*/
	@NotBlank(message="パスワードが未入力です。")
	private String password;
	
	
	
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
	
	@Override
	public String toString() {
		return "LoginForm [email=" + email + ", password=" + password + "]";
	}
	
	
	
}
