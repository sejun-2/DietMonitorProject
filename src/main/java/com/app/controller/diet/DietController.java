package com.app.controller.diet;

import java.util.ArrayList;
import java.util.List; 

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.dto.diet.Diet;
import com.app.dto.search.Nutrient;
import com.app.dto.user.NutritionStandard;
import com.app.dto.user.User;
import com.app.service.diet.DietService;
import com.app.service.search.SearchService;
import com.app.service.user.UserService;
import com.app.util.NutritionCalculator;
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
	public String dailyDiet(HttpSession session, Model model, User user, Diet diet) {

		int accountNo = SessionManager.getAccountNo(session);
		int memberNo = SessionManager.getMemberNo(session);
		
		user.setAccountNo(accountNo);
		user.setMemberNo(memberNo);
		
		List<Diet> dailyDiet = dietService.findFoodListByMemberInfo(user);
		Diet totalNutrient = dietService.getTotalNutrientFromDailyDietByMemberInfo(user);
		List<Nutrient> unitList = searchService.findNutrientList();
		List<Double> recommendedIntake = dietService.getRecommendedIntakeByMemberInfo(user);
		List<Double> calculatedNutrients = NutritionCalculator.calculateStandardMinusTotalIntake(recommendedIntake, totalNutrient);
		
		System.out.println("나의 영양 일일 권장량 : " + recommendedIntake);
		System.out.println("나의 하루 섭취 식품 : " + dailyDiet);
		System.out.println("등록 식품 영양성분 함량 합계 : " + totalNutrient);
		
		model.addAttribute("dailyDiet", dailyDiet);
		model.addAttribute("totalNutrient", totalNutrient);
		model.addAttribute("unitList", unitList);
		model.addAttribute("calculatedNutrients", calculatedNutrients);
		
		return "diet/dailyDiet";
	}
	
	@PostMapping("/deleteDiet")
	public String deleteDiet(int logNo) {
		
		System.out.println("dailyDiet 페이지에서 deleteDiet로 넘어온 logNo = " + logNo);
		int result = dietService.deleteDiet(logNo);
		System.out.println("deleteDiet 실행 결과 : " + result);
		
		return "redirect:/diet/dailyDiet";
	}
}
