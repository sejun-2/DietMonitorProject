package com.app.service.search.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.search.SearchDAO;
import com.app.dto.search.Food;
import com.app.dto.search.Nutrient;
import com.app.dto.search.SearchCategory;
import com.app.dto.search.SearchInfo;
import com.app.service.search.SearchService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    SearchDAO searchDAO;

    @Override
    public List<SearchCategory> findDataSortList() {
        try {
            List<SearchCategory> searchCategoryList = searchDAO.findDataSortList();
            log.debug("SearchServiceImpl findDataSortList : {}", searchCategoryList);
            return searchCategoryList;
        } catch (Exception e) {
            log.error("SearchServiceImpl findDataSortList : {}", e.toString());
        }

        return null;
    }

    @Override
    public List<SearchCategory> findMainCategoryList() {
        try {
            List<SearchCategory> searchCategoryList = searchDAO.findMainCategoryList();
            log.debug("SearchServiceImpl findMainCategoryList : {}", searchCategoryList);
            return searchCategoryList;
        } catch (Exception e) {
            log.error("SearchServiceImpl findMainCategoryList : {}", e.toString());
        }

        return null;
    }

    @Override
    public int findFoodTotalItems(SearchInfo searchInfo) {
        try {
            int foodTotalItems = searchDAO.findFoodTotalItems(searchInfo);
            log.debug("SearchServiceImpl findFoodTotalItems : {}", foodTotalItems);
            return foodTotalItems;
        } catch (Exception e) {
            log.error("SearchServiceImpl findFoodTotalItems : {}", e.toString());
        }

        return 0;
    }

    @Override
    public List<Food> findFoodList(SearchInfo searchInfo) {
        try {
            List<Food> foodList = searchDAO.findFoodList(searchInfo);
            log.debug("SearchServiceImpl findFoodList : {}", foodList);
            return foodList;
        } catch (Exception e) {
            log.error("SearchServiceImpl findFoodList : {}", e.toString());
        }

        return null;
    }

    @Override
    public Food findFoodByFoodCode(String foodCode) {
        try {
            Food food = searchDAO.findFoodByFoodCode(foodCode);
            log.debug("SearchServiceImpl findFoodByFoodCode : {}", food);
            return food;
        } catch (Exception e) {
            log.error("SearchServiceImpl findFoodByFoodCode : {}", e.toString());
        }

        return null;
    }

    @Override
    public List<Nutrient> findNutrientList() {
        try {
            List<Nutrient> nutrientList = searchDAO.findNutrientList();
            log.debug("SearchServiceImpl findNutrientList : {}", nutrientList);
            return nutrientList;
        } catch (Exception e) {
            log.error("SearchServiceImpl findNutrientList : {}", e.toString());
        }

        return null;
    }
}
