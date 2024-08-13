package com.app.dao.diet.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.diet.DietDAO;
import com.app.dto.diet.Diet;
import com.app.dto.diet.Nutrients;
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
	public Nutrients findTotalNutrientFromDailyDietByMemberInfo(User user) {
		// TODO Auto-generated method stub
		Nutrients totalNutrient = sqlSessionTemplate.selectOne("diet_mapper."
						+ "findTotalNutrientFromDailyDietByMemberInfo", user);
		
		return totalNutrient;
	}

}
