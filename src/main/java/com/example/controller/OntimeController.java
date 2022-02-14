package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Ontime;
import com.example.form.OntimeForm;
import com.example.repository.OntimeRepository;

@Controller
@RequestMapping("/setting")
public class OntimeController {
	
		@Autowired
		private OntimeRepository ontimesRepository;
		
		@ModelAttribute
		public OntimeForm setUpOntimesForm() {
			return new OntimeForm();
		}
		
		/*定時設定画面の表示*/
		@RequestMapping("")
		public String settign() {
			return "setting";
		}
		
		@RequestMapping("/inputSetting")
		public String inputOntime(OntimeForm ontimeForm,Model model) {
			Ontime ontime = new Ontime();
			
			ontime.setUserId(OntimeForm.getUserId());
			ontime.setStandardStartTime(OntimeForm.getStandardStartTime());
			ontime.setStandardEndTime(OntimeForm.getStandardEndTime());
//			ontimes.setBreakTime(OntimesForm.getBreakTime());
//			ontimesRepository.load(ontime);
			
			ontimesRepository.save(ontime);
			
			return "redirect:/index";
		}
		
		
		

	}


