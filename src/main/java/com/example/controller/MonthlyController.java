package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Monthly;
import com.example.form.MonthlyForm;
import com.example.service.MonthlyService;

@Controller
@RequestMapping("/monthly")
public class MonthlyController {
	
	/*formクラスをインスタンス化*/
	@ModelAttribute
	public MonthlyForm setUpForm() {
		return new MonthlyForm();
	}
	
	@Autowired
	private MonthlyService monthlyService;
	
	@Autowired
	private HttpSession session;
	
	/*月次勤怠ページを表示*/
	@RequestMapping("")
	public String monthly() {
		return "monthly";
	}
	
	/*月選択時の処理*/
	@RequestMapping("/viewMonthly")
	public String viewMonthly(MonthlyForm monthlyForm,Model model) {
		Monthly monthly = new Monthly();
		/*受け取った月を格納しserviceクラスに引き渡す*/
		monthly.setUserId(monthlyForm.getUserId());    // ユーザーID
		monthly.setYearMonth(monthlyForm.yearMonth()); // 年月(0000年0月）
		/*年月から年と月をそれぞれ取り出し各要素にセット*/
		monthly.setYear(Integer.parseInt(monthly.getYearMonth().substring(0,4)));
		monthly.setMonth(Integer.parseInt(monthly.getYearMonth().substring(5,7)));
//		monthlyService.save(monthly);
		List<Monthly> monthlyList = monthlyService.load(monthly);
//		if(monthlyList.size() == 0) {
//			monthlyService.save(monthly);
//		}
		session.setAttribute("monthlyList",monthlyList);
		return "redirect:/monthly";
	}
	
	
	

}
