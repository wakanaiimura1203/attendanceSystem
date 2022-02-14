package com.example.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.domain.User;
import com.example.form.CreateAccountForm;
import com.example.service.CreateAccountService;

@Controller
@RequestMapping("/createAccount")
public class CreateAccountController {
	
	@Autowired
	private CreateAccountService createAccountService;
	
	// フォームクラスをインスタンス化
	@ModelAttribute
	public CreateAccountForm setUpForm() {
		return new CreateAccountForm();
	}
	
	/*初回のアカウント登録用ページを表示するメソッド*/
	@RequestMapping("")
	public String createAccount() {
		return "create-account";
	}
	
	/*ユーザー登録処理を行うメソッド
	 * @param ユーザー情報用フォーム
	 * @return ログイン画面へリダイレクト
	 * */
	@RequestMapping("/insert")
	public String insert(@Validated CreateAccountForm form,BindingResult result,Model model) {
		
		String name = form.getName().strip();
		if(name.equals("")) {
			model.addAttribute("spaceOnlyName", "全角スペースのみでは登録できません");
			return createAccount();
		}
		
		if(result.hasErrors()) {
			return createAccount();
		}
		
		if(!form.getPassword().equals(form.getConfirmPassword())) {
			model.addAttribute("passError", "パスワードと確認用パスワードが不一致です");
			return createAccount();
		}
		
		User user = new User();
		BeanUtils.copyProperties(form, user);
		user.setName(name);
		
		// 登録処理
		try {
			createAccountService.insert(user);
		} catch(DuplicateKeyException e) {
			model.addAttribute("dupricateMail", "入力されたメールアドレスは既に使用されています");
			return createAccount();
		}
		
		// ログイン画面へリダイレクト
		return "redirect:/createAccount/successCreate";
	}
	
	@RequestMapping("/successCreate")
	public static String successCreate(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("successCreateMessage", "初回登録が完了しました。");
		return "redirect:/login";
	}

}
