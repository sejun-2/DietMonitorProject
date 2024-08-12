package com.app.dao.mypage;

import java.util.List;

import com.app.dto.mypage.TotalDiet;
import com.app.dto.mypage.TotalDietSearchCondition;
import com.app.dto.search.Food;

public interface MypageDAO {
	
	public List<TotalDiet> findTotalDietBySearchCondition(TotalDietSearchCondition totalDietSearchCondition);
	
	public List<TotalDiet> findTotalDietByAvg(TotalDietSearchCondition totalDietSearchCondition);
	
	public List<TotalDiet> findTotalDietBySaveHistory(TotalDietSearchCondition totalDietSearchCondition);
	
	public List<TotalDiet> findTotalDietBySaveHistoryAvg(TotalDietSearchCondition totalDietSearchCondition);
	
	public List<TotalDiet> findTotalDietByMonthSum(TotalDietSearchCondition totalDietSearchCondition);

}
