package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Monthly;
import com.example.form.DailyForm;
import com.example.form.MonthlyForm;
import com.example.repository.DailyRepository;

@Controller
@RequestMapping("/daily")
public class DailyController {
	
	@ModelAttribute
	public DailyForm setUpForm1() {
	return new DailyForm();
	}
	
	@ModelAttribute
	public MonthlyForm setUpForm2() {
	return new MonthlyForm();
	}
	
	@Autowired
	private DailyRepository dailyRepository;
	
//	@Autowired
//	private DailyService dailyService;
	
	@RequestMapping("")
	public String daily() {
		return "daily";
	}
	
	/*年月日選択時の処理*/
	@RequestMapping("/viewDaily")
	public String viewDaily(DailyForm dailyForm ,MonthlyForm monthlyForm, Model model) {
		Monthly dailyData = new Monthly();
		dailyData.setUserId(dailyForm.getUserId());
		dailyData.setYear(Integer.parseInt(dailyForm.getYearMonthDay().substring(0,4)));
		dailyData.setMonth(Integer.parseInt(dailyForm.getYearMonthDay().substring(5,7)));
		dailyData.setDay(Integer.parseInt(dailyForm.getYearMonthDay().substring(8,10)));
		dailyData.setAttendanceStatus(dailyForm.getAttendanceStatus());
		dailyData.setStartTime(dailyForm.getStartTime());
		dailyData.setEndTime(dailyForm.getEndTime());
		dailyData.setBreakTime(dailyForm.getBreakTime());
		dailyData.setComment(dailyForm.getComment());
		dailyRepository.save(dailyData);
		return "redirect:/daily";
		
	}
}
