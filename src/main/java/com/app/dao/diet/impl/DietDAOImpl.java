package com.app.dao.diet.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.diet.DietDAO;
import com.app.dto.diet.Diet;

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

}
