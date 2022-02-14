package com.example.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.User;
import com.example.service.WorkingUserService;

@Controller
@RequestMapping("/working-users")
public class WorkingUserCotroller {
	
	@Autowired
	private WorkingUserService workingUserService;
	
//	@Autowired
//	private WorkingUserService workingUserService;
	
	@RequestMapping("")
	public String workingUser(Model model) {
		
		/* workingListに勤務中ステータスのユーザ情報を格納
		 * リクエストスコープにworkingListを格納し、html側でループ処理を行う
		 */
		List<User> workingList = workingUserService.findByWorkingUser();
		if(workingList == null) {
			return null;
		} else {
			model.addAttribute("workingList" , workingList);
		}
		return "working-users";
	}
//	/*勤務中ユーザ一覧取得のための処理*/
//	@RequestMapping("")
//	public String workingUser(Model model) {
//		List<User> workingList= workingUserService.findByWorkingUser();
//		for (User user : workingList) {
//			session.setAttribute("workingList", user);
//		}
//		
//		if(workingList == null) {
//			return null;
//		}
//		return  "working-users";
//	}
//	

}
