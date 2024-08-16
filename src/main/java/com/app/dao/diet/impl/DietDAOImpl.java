package com.app.dao.diet.impl;

import java.util.List; 

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.diet.DietDAO;
import com.app.dto.diet.Diet;
import com.app.dto.user.User;

@Repository
public class DietDAOImpl implements DietDAO {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int addFoodToDailyDiet(Diet diet) {
		// TODO Auto-generated method stub
		int result = sqlSessionTemplate.insert("diet_mapper.addFoodToDailyDiet", diet);
		
		return result;
	}

	@Override
	public List<Diet> findFoodListByMemberInfo(User user) {
		// TODO Auto-generated method stub
		List<Diet> dailyDiet = 
				sqlSessionTemplate.selectList("diet_mapper.findFoodListByMemberInfo", user);
		
		return dailyDiet;
	}

	@Override
	public Diet getTotalNutrientFromDailyDietByMemberInfo(User user) {
		// TODO Auto-generated method stub
		Diet totalNutrient = sqlSessionTemplate.selectOne("diet_mapper."
						+ "getTotalNutrientFromDailyDietByMemberInfo", user);
		
		return totalNutrient;
	}

	@Override
	public int deleteDiet(int logNo) {
		// TODO Auto-generated method stub
		int result = sqlSessionTemplate.delete("diet_mapper.deleteDiet", logNo);
		
		return result;
	}

	@Override
	public int saveDailyDietToTotalDiet() {
		// TODO Auto-generated method stub
		int result = sqlSessionTemplate.update("diet_mapper.saveDailyDietToTotalDiet");
		
		return result;
	}

	@Override
	public List<Double> getRecommendedIntakeByMemberInfo(User user) {
		// TODO Auto-generated method stub
		List<Double> result = sqlSessionTemplate.selectList("diet_mapper."
				+ "getRecommendedIntakeByMemberInfo", user);
		
		return result;
	}

}
