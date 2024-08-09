package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession; 

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.dto.user.NutritionStandard;
import com.app.util.NutritionCalculator;
import com.app.util.SessionManager;

@Controller
public class HomeController {

	@GetMapping("/")
	public String root() {
		return "redirect:/main";
	}
	
	@GetMapping("/main")
	public String main(HttpSession session) {
		
		return "index";
	}
	
	
}
