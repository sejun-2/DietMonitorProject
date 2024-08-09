package com.app.service.diet.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.diet.DietDAO;
import com.app.dto.diet.Diet;
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

}
