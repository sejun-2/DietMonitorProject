package com.app.controller;

import javax.servlet.http.HttpSession; 

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
