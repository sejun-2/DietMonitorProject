package com.app.dao.diet;

import java.util.List;

import com.app.dto.diet.Diet;
import com.app.dto.diet.Nutrients;
import com.app.dto.user.User;

public interface DietDAO {

	int addFoodToDailyDiet(Diet diet);

	List<Diet> findFoodListByMemberInfo(User user);

	Nutrients findTotalNutrientFromDailyDietByMemberInfo(User user);

}
