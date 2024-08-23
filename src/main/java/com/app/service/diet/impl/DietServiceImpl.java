package com.app.service.diet.impl;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.diet.DietDAO;
import com.app.dto.diet.Diet;
import com.app.dto.user.User;
import com.app.service.diet.DietService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DietServiceImpl implements DietService {

    @Autowired
    DietDAO dietDAO;

    @Override
    public int addFoodToDailyDiet(Diet diet) {
        try {
            int result = dietDAO.addFoodToDailyDiet(diet);
            log.debug("DietServiceImpl addFoodToDailyDiet : {}", result);
            return result;
        } catch (Exception e) {
            log.error("DietServiceImpl addFoodToDailyDiet : {}", e.toString());
        }
        return 0;
    }

    @Override
    public List<Diet> findDailyDietListByMemberInfo(User user) {
        try {
            List<Diet> dailyDiet = dietDAO.findDailyDietListByMemberInfo(user);
            log.debug("DietServiceImpl findDailyDietListByMemberInfo : {}", dailyDiet);
            return dailyDiet;
        } catch (Exception e) {
            log.error("DietServiceImpl findDailyDietListByMemberInfo : {}", e.toString());
        }
        return null;
    }

    @Override
    public Diet getTotalNutrientFromDailyDietByMemberInfo(User user) {
        try {
            Diet totalNutrient = dietDAO.getTotalNutrientFromDailyDietByMemberInfo(user);
            log.debug("DietServiceImpl getTotalNutrientFromDailyDietByMemberInfo : {}", totalNutrient);
            return totalNutrient;
        } catch (Exception e) {
            log.error("DietServiceImpl getTotalNutrientFromDailyDietByMemberInfo : {}", e.toString());
        }
        return null;
    }

    @Override
    public int deleteSelectedDailyDiet(int logNo) {
        try {
            int result = dietDAO.deleteSelectedDailyDiet(logNo);
            log.debug("DietServiceImpl deleteSelectedDailyDiet : {}", result);
            return result;
        } catch (Exception e) {
            log.error("DietServiceImpl deleteSelectedDailyDiet : {}", e.toString());
        }
        return 0;
    }

    @Override
    public int deleteAllDailyDiet(User user) {
        try {
            int result = dietDAO.deleteAllDailyDiet(user);
            log.debug("DietServiceImpl deleteAllDailyDiet : {}", result);
            return result;
        } catch (Exception e) {
            log.error("DietServiceImpl deleteAllDailyDiet : {}", e.toString());
        }
        return 0;
    }

    @Override
    public int deleteSelectedExpectedDiet(int logNo) {
        try {
            int result = dietDAO.deleteSelectedExpectedDiet(logNo);
            log.debug("DietServiceImpl deleteSelectedExpectedDiet : {}", result);
            return result;
        } catch (Exception e) {
            log.error("DietServiceImpl deleteSelectedExpectedDiet : {}", e.toString());
        }
        return 0;
    }

    @Override
    public int deleteAllExpectedDiet(User user) {
        try {
            int result = dietDAO.deleteAllExpectedDiet(user);
            log.debug("DietServiceImpl deleteAllExpectedDiet : {}", result);
            return result;
        } catch (Exception e) {
            log.error("DietServiceImpl deleteAllExpectedDiet : {}", e.toString());
        }
        return 0;
    }

    @Override
    public int saveDailyDietToTotalDiet() {
        try {
            int result = dietDAO.saveDailyDietToTotalDiet();
            log.debug("DietServiceImpl saveDailyDietToTotalDiet : {}", result);
            return result;
        } catch (Exception e) {
            log.error("DietServiceImpl saveDailyDietToTotalDiet : {}", e.toString());
        }
        return 0;
    }

    @Override
    public List<Double> getRecommendedIntakeByMemberInfo(User user) {
        try {
            List<Double> result = dietDAO.getRecommendedIntakeByMemberInfo(user);
            log.debug("DietServiceImpl getRecommendedIntakeByMemberInfo : {}", result);
            return result;
        } catch (Exception e) {
            log.error("DietServiceImpl getRecommendedIntakeByMemberInfo : {}", e.toString());
        }
        return null;
    }

    @Override
    public int addFoodToExpectedDiet(Diet diet) {
        try {
            int result = dietDAO.addFoodToExpectedDiet(diet);
            log.debug("DietServiceImpl addFoodToExpectedDiet : {}", result);
            return result;
        } catch (Exception e) {
            log.error("DietServiceImpl addFoodToExpectedDiet : {}", e.toString());
        }
        return 0;
    }

    @Override
    public List<Diet> findExpectedDietListByMemberInfo(User user) {
        try {
            List<Diet> expectedDiet = dietDAO.findExpectedDietListByMemberInfo(user);
            log.debug("DietServiceImpl findExpectedDietListByMemberInfo : {}", expectedDiet);
            return expectedDiet;
        } catch (Exception e) {
            log.error("DietServiceImpl findExpectedDietListByMemberInfo : {}", e.toString());
        }
        return null;
    }

    @Override
    public Diet getExpectedTotalNutrientFromDailyDietByMemberInfo(User user) {
        try {
            Diet expectedTotalNutrient = dietDAO.getExpectedTotalNutrientFromDailyDietByMemberInfo(user);
            log.debug("DietServiceImpl getExpectedTotalNutrientFromDailyDietByMemberInfo : {}", expectedTotalNutrient);
            return expectedTotalNutrient;
        } catch (Exception e) {
            log.error("DietServiceImpl getExpectedTotalNutrientFromDailyDietByMemberInfo : {}", e.toString());
        }
        return null;
    }
}
