package com.app.dao.diet.impl;

import java.util.List; 

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.diet.DietDAO;
import com.app.dto.diet.Diet;
import com.app.dto.user.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class DietDAOImpl implements DietDAO {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int addFoodToDailyDiet(Diet diet) {
		
		try {
			int result = sqlSessionTemplate.insert("diet_mapper.addFoodToDailyDiet", diet);	
			log.debug("DietDAOImpl addFoodToDailyDiet : {}", result);
			return result;
		} catch (Exception e) {
			log.error("DietDAOImpl addFoodToDailyDiet : {}", e.toString());
		}
		
		return 0;
	}

	@Override
	public List<Diet> findDailyDietListByMemberInfo(User user) {
		
		try {
			List<Diet> dailyDiet = 
					sqlSessionTemplate.selectList("diet_mapper.findDailyDietListByMemberInfo", user);	
			log.debug("DietDAOImpl findDailyDietListByMemberInfo : {}", dailyDiet);
			return dailyDiet;
		} catch (Exception e) {
			log.error("DietDAOImpl findDailyDietListByMemberInfo : {}", e.toString());
		}
		
		return null;
	}

	@Override
	public Diet getTotalNutrientFromDailyDietByMemberInfo(User user) {
		
		try {
			Diet totalNutrient = sqlSessionTemplate.selectOne("diet_mapper."
					+ "getTotalNutrientFromDailyDietByMemberInfo", user);	
			log.debug("DietDAOImpl getTotalNutrientFromDailyDietByMemberInfo : {}", totalNutrient);
			return totalNutrient;
		} catch (Exception e) {
			log.error("DietDAOImpl getTotalNutrientFromDailyDietByMemberInfo : {}", e.toString());
		}
		
		return null;
	}

	@Override
	public int deleteSelectedDailyDiet(int logNo) {
		
		try {
			int result = sqlSessionTemplate.delete("diet_mapper.deleteSelectedDailyDiet", logNo);	
			log.debug("DietDAOImpl deleteSelectedDailyDiet : {}", result);
			return result;
		} catch (Exception e) {
			log.error("DietDAOImpl deleteSelectedDailyDiet : {}", e.toString());
		}
		
		return 0;
	}
	
	@Override
	public int deleteAllDailyDiet(User user) {
		
		try {
			int result = sqlSessionTemplate.delete("diet_mapper.deleteAllDailyDiet", user);	
			log.debug("DietDAOImpl deleteAllDailyDiet : {}", result);
			return result;
		} catch (Exception e) {
			log.error("DietDAOImpl deleteAllDailyDiet : {}", e.toString());
		}
		
		return 0;
	}
	
	@Override
	public int deleteSelectedExpectedDiet(int logNo) {
		
		try {
			int result = sqlSessionTemplate.delete("diet_mapper.deleteSelectedExpectedDiet", logNo);	
			log.debug("DietDAOImpl deleteSelectedExpectedDiet : {}", result);
			return result;
		} catch (Exception e) {
			log.error("DietDAOImpl deleteSelectedExpectedDiet : {}", e.toString());
		}
		
		return 0;
	}
	
	@Override
	public int deleteAllExpectedDiet(User user) {
		
		try {
			int result = sqlSessionTemplate.delete("diet_mapper.deleteAllExpectedDiet", user);	
			log.debug("DietDAOImpl deleteAllExpectedDiet : {}", result);
			return result;
		} catch (Exception e) {
			log.error("DietDAOImpl deleteAllExpectedDiet : {}", e.toString());
		}
		
		return 0;
	}

	@Override
	public int saveDailyDietToTotalDiet() {
		
		try {
			int result = sqlSessionTemplate.update("diet_mapper.saveDailyDietToTotalDiet");	
			log.debug("DietDAOImpl saveDailyDietToTotalDiet : {}", result);
			return result;
		} catch (Exception e) {
			log.error("DietDAOImpl saveDailyDietToTotalDiet : {}", e.toString());
		}
		
		return 0;
	}

	@Override
	public List<Double> getRecommendedIntakeByMemberInfo(User user) {
		
		try {
			List<Double> result = sqlSessionTemplate.selectList("diet_mapper."
					+ "getRecommendedIntakeByMemberInfo", user);	
			log.debug("DietDAOImpl getRecommendedIntakeByMemberInfo : {}", result);
			return result;
		} catch (Exception e) {
			log.error("DietDAOImpl getRecommendedIntakeByMemberInfo : {}", e.toString());
		}
		
		return null;
	}

	@Override
	public int addFoodToExpectedDiet(Diet diet) {
		
		try {
			int result = sqlSessionTemplate.insert("diet_mapper.addFoodToExpectedDiet", diet);	
			log.debug("DietDAOImpl addFoodToExpectedDiet : {}", result);
			return result;
		} catch (Exception e) {
			log.error("DietDAOImpl addFoodToExpectedDiet : {}", e.toString());
		}
		
		return 0;
	}

	@Override
	public List<Diet> findExpectedDietListByMemberInfo(User user) {
		
		try {
			List<Diet> expectedDiet = 
					sqlSessionTemplate.selectList("diet_mapper.findExpectedDietListByMemberInfo", user);	
			log.debug("DietDAOImpl findExpectedDietListByMemberInfo : {}", expectedDiet);
			return expectedDiet;
		} catch (Exception e) {
			log.error("DietDAOImpl findExpectedDietListByMemberInfo : {}", e.toString());
		}
		
		return null;
	}

	@Override
	public Diet getExpectedTotalNutrientFromDailyDietByMemberInfo(User user) {
		
		try {
			Diet expectedTotalNutrient = sqlSessionTemplate.selectOne("diet_mapper."
					+ "getExpectedTotalNutrientFromDailyDietByMemberInfo", user);	
			log.debug("DietDAOImpl getExpectedTotalNutrientFromDailyDietByMemberInfo : {}", expectedTotalNutrient);
			return expectedTotalNutrient;
		} catch (Exception e) {
			log.error("DietDAOImpl getExpectedTotalNutrientFromDailyDietByMemberInfo : {}", e.toString());
		}
		
		return null;		
	}
}
