package com.app.service.mypage.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.mypage.MypageDAO;
import com.app.dto.diet.Diet;
import com.app.dto.mypage.TotalDietSearchCondition;
import com.app.service.mypage.MypageService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MypageServiceImpl implements MypageService {

    @Autowired
    MypageDAO mypageDAO;

    @Override
    public List<Diet> findTotalDietBySearchCondition(TotalDietSearchCondition totalDietSearchCondition) {
        try {
            List<Diet> totalDietList = mypageDAO.findTotalDietBySearchCondition(totalDietSearchCondition);
            log.debug("MypageServiceImpl findTotalDietBySearchCondition : {}", totalDietList);
            return totalDietList;
        } catch (Exception e) {
            log.error("MypageServiceImpl findTotalDietBySearchCondition : {}", e.toString());
        }
        return null;
    }

    @Override
    public Diet findTotalDietByAvg(TotalDietSearchCondition totalDietSearchCondition) {
        try {
            Diet totalDiet = mypageDAO.findTotalDietByAvg(totalDietSearchCondition);
            log.debug("MypageServiceImpl findTotalDietByAvg : {}", totalDiet);
            return totalDiet;
        } catch (Exception e) {
            log.error("MypageServiceImpl findTotalDietByAvg : {}", e.toString());
        }
        return null;
    }

    @Override
    public List<Diet> findTotalDietBySaveHistory(TotalDietSearchCondition totalDietSearchCondition) {
        try {
            List<Diet> totalDietList = mypageDAO.findTotalDietBySaveHistory(totalDietSearchCondition);
            log.debug("MypageServiceImpl findTotalDietBySaveHistory : {}", totalDietList);
            return totalDietList;
        } catch (Exception e) {
            log.error("MypageServiceImpl findTotalDietBySaveHistory : {}", e.toString());
        }
        return null;
    }

    @Override
    public List<Diet> findTotalDietBySaveHistorySum(TotalDietSearchCondition totalDietSearchCondition) {
        try {
            List<Diet> totalDietListSum = mypageDAO.findTotalDietBySaveHistorySum(totalDietSearchCondition);
            log.debug("MypageServiceImpl findTotalDietBySaveHistorySum : {}", totalDietListSum);
            return totalDietListSum;
        } catch (Exception e) {
            log.error("MypageServiceImpl findTotalDietBySaveHistorySum : {}", e.toString());
        }
        return null;
    }

    @Override
    public List<Diet> findTotalDietByMonthSum(TotalDietSearchCondition totalDietSearchCondition) {
        try {
            List<Diet> totalDietListMonthSum = mypageDAO.findTotalDietByMonthSum(totalDietSearchCondition);
            log.debug("MypageServiceImpl findTotalDietByMonthSum : {}", totalDietListMonthSum);
            return totalDietListMonthSum;
        } catch (Exception e) {
            log.error("MypageServiceImpl findTotalDietByMonthSum : {}", e.toString());
        }
        return null;
    }

    @Override
    public List<Diet> findTotalDietByStandard(TotalDietSearchCondition totalDietSearchCondition) {
        try {
            List<Diet> findTotalDietByStandard = mypageDAO.findTotalDietByStandard(totalDietSearchCondition);
            log.debug("MypageServiceImpl findTotalDietByStandard : {}", findTotalDietByStandard);
            return findTotalDietByStandard;
        } catch (Exception e) {
            log.error("MypageServiceImpl findTotalDietByStandard : {}", e.toString());
        }
        return null;
    }
}
