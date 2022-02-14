package com.example.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.User;
import com.example.form.LoginForm;
import com.example.service.LoginService;

/**
 * @author shirayamawakana ログイン・ログアウト機能用のController
 *
 */
@Controller
@RequestMapping("")
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@Autowired
	private HttpSession session;

	/**
	 * 使用するフォームオブジェクトをリクエストスコープに格納する
	 * 
	 * @return LoginForm
	 */
	@ModelAttribute
	public LoginForm setUpLoginForm() {
		return new LoginForm();
	}

	/* ログインページへのフォワード処理 */
	@RequestMapping("")
	public String login() {
		return "login";
	}

	/**
	 * ログイン処理
	 * 
	 * @param form   ユーザー情報用フォーム
	 * @param result エラー情報格納用オブジェクト
	 * @return ログイン後のトップページ画面
	 */
	@RequestMapping("/login")
	public String toLogin(@Validated LoginForm form, BindingResult result, Model model) {
		User user = loginService.login(form.getEmail(), form.getPassword());
		if (result.hasErrors()) {
			return login();
		}

		if (user == null) {
			model.addAttribute("erroeMessage", "メールアドレスまたはパスワードに誤りがあります。");
			return login();
		}

		/** ユーザー情報を表示するための処理 */
		session.setAttribute("user", user);

		return "index";

	}

	/** ログアウト処理 */
	@RequestMapping(value = "/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/";
	}

}
