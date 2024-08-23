package com.app.dao.mypage.impl;

import java.util.List; 

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.mypage.MypageDAO;
import com.app.dto.diet.Diet;
import com.app.dto.mypage.TotalDietSearchCondition;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class MypageDAOImpl implements MypageDAO {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;


	@Override
	public List<Diet> findTotalDietBySearchCondition(TotalDietSearchCondition totalDietSearchCondition) {
		
		try {
			List<Diet> totalDietList = sqlSessionTemplate.selectList("mypage_mapper.findTotalDietBySearchCondition", totalDietSearchCondition);	
			log.debug("MypageDAOImpl findTotalDietBySearchCondition : {}", totalDietList);
			return totalDietList;
		} catch (Exception e) {
			log.error("MypageDAOImpl findTotalDietBySearchCondition : {}", e.toString());
		}
		
		return null;
	}


	@Override
	public Diet findTotalDietByAvg(TotalDietSearchCondition totalDietSearchCondition) {
		
		try {
			Diet totalDiet = sqlSessionTemplate.selectOne("mypage_mapper.findTotalDietByAvg", totalDietSearchCondition);	
			log.debug("MypageDAOImpl findTotalDietByAvg : {}", totalDiet);
			return totalDiet;
		} catch (Exception e) {
			log.error("MypageDAOImpl findTotalDietByAvg : {}", e.toString());
		}
		
		return null;
	}


	@Override
	public List<Diet> findTotalDietBySaveHistory(TotalDietSearchCondition totalDietSearchCondition) {
		
		try {
			List<Diet> totalDietList = sqlSessionTemplate.selectList("mypage_mapper.findTotalDietBySaveHistory", totalDietSearchCondition);	
			log.debug("MypageDAOImpl findTotalDietBySaveHistory : {}", totalDietList);
			return totalDietList;
		} catch (Exception e) {
			log.error("MypageDAOImpl findTotalDietBySaveHistory : {}", e.toString());
		}
		
		return null;
	}


	@Override
	public List<Diet> findTotalDietBySaveHistorySum(TotalDietSearchCondition totalDietSearchCondition) {
		
		try {
			List<Diet> totalDietListSum = sqlSessionTemplate.selectList("mypage_mapper.findTotalDietBySaveHistorySum", totalDietSearchCondition);	
			log.debug("MypageDAOImpl findTotalDietBySaveHistorySum : {}", totalDietListSum);
			return totalDietListSum;
		} catch (Exception e) {
			log.error("MypageDAOImpl findTotalDietBySaveHistorySum : {}", e.toString());
		}
		
		return null;
	}


	@Override
	public List<Diet> findTotalDietByMonthSum(TotalDietSearchCondition totalDietSearchCondition) {
		
		try {
			List<Diet> totalDietListMonthSum = sqlSessionTemplate.selectList("mypage_mapper.findTotalDietByMonthSum", totalDietSearchCondition);	
			log.debug("MypageDAOImpl findTotalDietByMonthSum : {}", totalDietListMonthSum);
			return totalDietListMonthSum;
		} catch (Exception e) {
			log.error("MypageDAOImpl findTotalDietByMonthSum : {}", e.toString());
		}
		
		return null;		
	}


	@Override
	public List<Diet> findTotalDietByStandard(TotalDietSearchCondition totalDietSearchCondition) {
		
		try {
			List<Diet> findTotalDietByStandard = sqlSessionTemplate.selectList("mypage_mapper.findTotalDietByStandard", totalDietSearchCondition);	
			log.debug("MypageDAOImpl findTotalDietByStandard : {}", findTotalDietByStandard);
			return findTotalDietByStandard;
		} catch (Exception e) {
			log.error("MypageDAOImpl findTotalDietByStandard : {}", e.toString());
		}
		
		return null;
	}
	
	

}
