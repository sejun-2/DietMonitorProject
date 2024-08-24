package com.app.service.mypage;

import java.util.List;

import com.app.dto.diet.Diet;
import com.app.dto.mypage.TotalDietSearchCondition;

public interface MypageService {
	
	public Diet findAvgWeeklyNutrientByMemberInfo(TotalDietSearchCondition totalDietSearchCondition);
	
	public List<Diet> findTotalDietBySearchCondition(TotalDietSearchCondition totalDietSearchCondition);
	
	public List<Diet> getDailyTotalNutrientBySearchCondition(TotalDietSearchCondition totalDietSearchCondition);
	
	public List<Diet> getDailyTotalNutrientForPast30DaysByMemberInfo(TotalDietSearchCondition totalDietSearchCondition);
	
	public List<Diet> getNutrientStandardByMemberInfo(TotalDietSearchCondition totalDietSearchCondition);
	
}
