package com.app.service.diet.impl;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.diet.DietDAO;
import com.app.dto.diet.Diet;
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
	public Diet getTotalNutrientFromDailyDietByMemberInfo(User user) {
		// TODO Auto-generated method stub
		Diet totalNutrient = dietDAO.getTotalNutrientFromDailyDietByMemberInfo(user);
		
		return totalNutrient;
	}

	@Override
	public int deleteDiet(int logNo) {
		// TODO Auto-generated method stub
		int result = dietDAO.deleteDiet(logNo);
		
		return result;
	}

	@Override
	public int saveDailyDietToTotalDiet() {
		// TODO Auto-generated method stub
		int result = dietDAO.saveDailyDietToTotalDiet();
		
		return result;
	}

	@Override
	public List<Double> getRecommendedIntakeByMemberInfo(User user) {
		// TODO Auto-generated method stub
		List<Double> result = dietDAO.getRecommendedIntakeByMemberInfo(user);
		
		return result;
	}

}
