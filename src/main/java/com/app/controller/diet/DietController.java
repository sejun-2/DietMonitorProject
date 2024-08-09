package com.app.controller.diet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.dto.diet.Diet;
import com.app.service.diet.DietService;

@Controller
public class DietController {
	
	@Autowired
	DietService dietService;
	
	@GetMapping("/myIntakeFood")
	public String myIntakeFood() {
		return "myIntakeFood";
	}
	
	@PostMapping("/myIntakeFood")
	public String myIntakeFoodAction(Diet diet) {
		
		int result = dietService.addFoodToDailyDiet(diet);
		 
				
		if(result > 0) {
			
		} else {
			
		}
		
		
		return "myIntakeFood";
	}
}
