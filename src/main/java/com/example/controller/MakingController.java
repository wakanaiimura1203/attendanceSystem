package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/making")
public class MakingController {

	@RequestMapping("")
	public String making() {
		return "making";
	}
}
