package com.app.service.mypage.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.mypage.MypageDAO;
import com.app.dto.diet.Diet;
import com.app.dto.mypage.TotalDietSearchCondition;
import com.app.service.mypage.MypageService;

@Service
public class MypageServiceImpl implements MypageService {
	
	@Autowired
	MypageDAO mypageDAO;

	@Override
	public List<Diet> findTotalDietBySearchCondition(TotalDietSearchCondition totalDietSearchCondition) {
		
		List<Diet> totalDietList = mypageDAO.findTotalDietBySearchCondition(totalDietSearchCondition);
		
		return totalDietList;
	}

	@Override
	public List<Diet> findTotalDietByAvg(TotalDietSearchCondition totalDietSearchCondition) {
		// TODO Auto-generated method stub
		List<Diet> totalDietList = mypageDAO.findTotalDietByAvg(totalDietSearchCondition);
		return totalDietList;
	}

	@Override
	public List<Diet> findTotalDietBySaveHistory(TotalDietSearchCondition totalDietSearchCondition) {
		// TODO Auto-generated method stub
		List<Diet> totalDietList = mypageDAO.findTotalDietBySaveHistory(totalDietSearchCondition);
		return totalDietList;
	}

	@Override
	public List<Diet> findTotalDietBySaveHistoryAvg(TotalDietSearchCondition totalDietSearchCondition) {
		// TODO Auto-generated method stub
		List<Diet> totalDietListAvg = mypageDAO.findTotalDietBySaveHistoryAvg(totalDietSearchCondition);
		return totalDietListAvg;
	}

	@Override
	public List<Diet> findTotalDietByMonthSum(TotalDietSearchCondition totalDietSearchCondition) {
		// TODO Auto-generated method stub
		List<Diet> totalDietListMonthSum = mypageDAO.findTotalDietByMonthSum(totalDietSearchCondition);
		return totalDietListMonthSum;
	}
	
	

	

}
