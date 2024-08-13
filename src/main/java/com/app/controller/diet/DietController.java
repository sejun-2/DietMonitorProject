package com.app.controller.diet;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.dto.diet.Diet;
import com.app.dto.user.User;
import com.app.service.diet.DietService;
import com.app.service.search.SearchService;
import com.app.service.user.UserService;
import com.app.util.SessionManager;

@Controller
public class DietController {
	
	@Autowired
	DietService dietService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	SearchService searchService;
	
	@PostMapping("/registerDiet")
	public String registerDiet(Diet diet,HttpSession session) {
		
		int accountNo = SessionManager.getAccountNo(session);
		int memberNo = SessionManager.getMemberNo(session);
		
		diet.setAccountNo(accountNo);
		diet.setMemberNo(memberNo);
		
		System.out.println("일일 식단 등록 데이터: " + diet);
		int result = dietService.addFoodToDailyDiet(diet);
		
		if(result > 0) {
			return "redirect:/diet/dailyDiet";
		} else {
			return "redirect:/search/foodDetail";
		}
	}
	
	@RequestMapping("/diet/dailyDiet")
	public String dailyDiet(HttpSession session, Model model, User user) {

		int accountNo = SessionManager.getAccountNo(session);
		int memberNo = SessionManager.getMemberNo(session);
		System.out.println(accountNo);
		System.out.println(memberNo);
		
		user.setAccountNo(accountNo);
		user.setMemberNo(memberNo);
		
		Diet totalNutrient = dietService.findTotalNutrientFromDailyDietByMemberInfo(user);
		List<Diet> dailyDiet = dietService.findFoodListByMemberInfo(user);
		System.out.println(dailyDiet);
		System.out.println(totalNutrient);
		
//		List<Food> foodList = searchService.findFoodListByMemberInfo(user);
		
		model.addAttribute("dailyDiet", dailyDiet);
		model.addAttribute("totalNutrient", totalNutrient);
		
		return "diet/dailyDiet";
	}
}
