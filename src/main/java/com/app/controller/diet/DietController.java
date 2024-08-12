package com.app.controller.diet;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.dto.diet.Diet;
import com.app.dto.search.Food;
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
	
	@GetMapping("/myIntakeFood")
	public String myIntakeFood() {
		return "myIntakeFood";
	}
	
	@PostMapping("/registerDiet")
	public String registerDiet(Diet diet,HttpSession session) {
		
		int accountNo = SessionManager.getAccountNo(session);
		int memberNo = SessionManager.getMemberNo(session);
		
		diet.setAccountNo(accountNo);
		diet.setMemberNo(memberNo);
		
		System.out.println("일일 식단 등록 데이터: " + diet);
		int result = dietService.addFoodToDailyDiet(diet);
		
		if(result > 0) {
			return "redirect:/myIntakeFood";
		} else {
			return "redirect:/foodDetail";
		}
	}
	
	
	@PostMapping("/myIntakeFood")
	public String myIntakeFoodAction(Diet diet,HttpSession session, Model model) {
		
		int accountNo = SessionManager.getAccountNo(session);
		int memberNo = SessionManager.getMemberNo(session);
		
		User user = new User();
		
		user.setAccountNo(accountNo);
		user.setMemberNo(memberNo);
		
		List<Diet> dailyDiet = dietService.findFoodListByMemberInfo(user);
		
//		List<Food> foodList = searchService.findFoodListByMemberInfo(user);
		
		model.addAttribute("dailyDiet", dailyDiet);
		
		return "myIntakeFood";
	}
}
