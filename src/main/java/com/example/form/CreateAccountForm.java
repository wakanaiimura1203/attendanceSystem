package com.example.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author shirayamawakana
 * ユーザー登録用のフォームクラス
 */
public class CreateAccountForm {
	
	@NotBlank(message="氏名を入力してください")
	private String name;
	@NotBlank(message="メールアドレスを入力してください")
	@Email(message="メールアドレスの形式が不正です")
	private String email;
	@NotBlank(message="パスワードを入力してください")
	@Size(min=8,max=20,message="パスワードは8文字以上20文字以内で設定してください")
	private String password;
	@NotBlank(message="確認用パスワードを入力してください")
	@Size(min=8,max=20,message="パスワードは8文字以上20文字以内で設定してください")
	private String confirmPassword;
	@NotBlank(message = "電話番号を入力して下さい")
	@Pattern(regexp = "^[0-9]{2,5}-[0-9]{1,4}-[0-9]{4}$" ,message = "電話番号はXXXX-XXXX-XXXXの形式で入力してください")
	private String telephone;
	
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
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	@Override
	public String toString() {
		return "CreateAccountForm [name=" + name + ", email=" + email + ", password=" + password + ", confirmPassword="
				+ confirmPassword + ", telephone=" + telephone + "]";
	}
	
	
}
