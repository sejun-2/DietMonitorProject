package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	
	@GetMapping("/index")
	public String main() {
		return "index";
	}
	
	@GetMapping("/")
	public String main2() {
		return "redirect:/index";
	}
}
