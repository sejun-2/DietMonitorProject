package com.app.service.diet.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.diet.DietDAO;
import com.app.dto.diet.Diet;
import com.app.dto.diet.Nutrients;
import com.app.dto.user.User;
import com.app.service.diet.DietService;

@Service
public class DietServiceImpl implements DietService{
	
	@Autowired
	DietDAO dietDAO;

	@Override
	public int addFoodToDailyDiet(Diet diet) {
		// TODO Auto-generated method stub
		int result = dietDAO.addFoodToDailyDiet(diet);
		
		return result;
	}

	@Override
	public List<Diet> findFoodListByMemberInfo(User user) {
		// TODO Auto-generated method stub
		List<Diet> dailyDiet = dietDAO.findFoodListByMemberInfo(user);
		
		return dailyDiet;
	}

	@Override
	public Nutrients findTotalNutrientFromDailyDietByMemberInfo(User user) {
		// TODO Auto-generated method stub
		Nutrients totalNutrient = dietDAO.findTotalNutrientFromDailyDietByMemberInfo(user);
		
		return totalNutrient;
	}

}
