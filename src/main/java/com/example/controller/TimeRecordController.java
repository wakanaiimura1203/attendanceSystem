package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Time;
import com.example.form.TimeForm;
import com.example.service.TimeRecordService;

@Controller
@RequestMapping("")
public class TimeRecordController {
	
	@Autowired
	private TimeRecordService timeRecordService;
	
	/*sessionスコープを使うための処理*/
	@Autowired
	private HttpSession session;
	
	/*Formクラスをインスタンス化*/
	@ModelAttribute
	public TimeForm setUpStartTimeForm() {
		return new TimeForm();
	}
	
	/* 「出勤」ボタン押下時の処理
	 * hiddenで送ったユーザーidをTimeFormクラスから受け取る。
	 *
	 *
	 */
	@RequestMapping("/startTime")
	public String updateStart(TimeForm timeForm,Model model) {
		Time time = new Time();
		/*受け取ったuserIdを格納しserviceクラスに引き渡す*/
		time.setUserId(TimeForm.getUserId());
		timeRecordService.save(time);
		
		/*勤怠情報を取得するための処理*/
		/*開始時間取得のための処理*/
		List<Time> timeList = timeRecordService.load(time.getUserId());
//		session.setAttribute("startList", timeList.get(0).getStartTime());
		session.setAttribute("timeList", timeList.get(0));
		if(timeList.get(0).getInputEndTime() == null) {
			timeList.get(0).setInputEndTime(" ");
		}
		return "redirect:/index";
	}
	
	/*「退勤」ボタン押下時の処理*/
	@RequestMapping("/endTime")
	public String updateEnd(TimeForm timeForm,Model model) {
		Time time = new Time();
		time.setUserId(TimeForm.getUserId());
		timeRecordService.save2(time);
		
		/*退勤時間取得のための処理*/
		List<Time> timeList = timeRecordService.load(time.getUserId());
		session.setAttribute("timeList", timeList.get(0));
		
		return "redirect:/index";
	}
	
	/*出勤時刻を記録するための
	@RequestMapping(value="/index",method=RequestMethod.POST)
	public String saveStartTime(@ModelAttribute StartTimeForm startTimeForm,Model model) {
		timeRecordService.update(startTimeForm.getStartTime());
		return "redirect:/index";
	}
	*/

	
	

}
