package com.app.service.diet;

import java.util.List; 

import com.app.dto.diet.Diet;
import com.app.dto.user.User;

public interface DietService {

	int addFoodToDailyDiet(Diet diet);

	List<Diet> findFoodListByMemberInfo(User user);

	Diet findTotalNutrientFromDailyDietByMemberInfo(User user);

	int deleteDiet(Diet diet);

}
