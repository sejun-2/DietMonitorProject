package com.app.dao.search.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.search.SearchDAO;
import com.app.dto.search.Food;
import com.app.dto.search.Nutrient;
import com.app.dto.search.SearchCategory;
import com.app.dto.search.SearchInfo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class SearchDAOImpl implements SearchDAO{

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<SearchCategory> findDataSortList() {
		
		try {
			List<SearchCategory> searchCategoryList = sqlSessionTemplate.selectList("search_mapper.findDataSortList");	
			log.debug("SearchDAOImpl findDataSortList : {}", searchCategoryList);
			return searchCategoryList;
		} catch (Exception e) {
			log.error("SearchDAOImpl findDataSortList : {}", e.toString());
		}
		
		return null;
	}
	
	@Override
	public List<SearchCategory> findMainCategoryList() {
		
		try {
			List<SearchCategory> searchCategoryList = sqlSessionTemplate.selectList("search_mapper.findMainCategoryList");
			log.debug("SearchDAOImpl findMainCategoryList : {}", searchCategoryList);
			return searchCategoryList;
		} catch (Exception e) {
			log.error("SearchDAOImpl findMainCategoryList : {}", e.toString());
		}
		
		return null;
	}
	
	@Override
	public int findFoodTotalItems(SearchInfo searchInfo) {
		
		try {
			int foodTotalItems = sqlSessionTemplate.selectOne("search_mapper.findfoodTotalItems", searchInfo);
			log.debug("SearchDAOImpl findFoodTotalItems : {}", foodTotalItems);
			return foodTotalItems;
		} catch (Exception e) {
			log.error("SearchDAOImpl findFoodTotalItems : {}", e.toString());
		}
		
		return 0;
	}
	
	@Override
	public List<Food> findFoodList(SearchInfo searchInfo) {
		
		try {
			List<Food> FoodList = sqlSessionTemplate.selectList("search_mapper.findFoodList", searchInfo);
			log.debug("SearchDAOImpl findFoodList : {}", FoodList);
			return FoodList;
		} catch (Exception e) {
			log.error("SearchDAOImpl findFoodList : {}", e.toString());
		}
		
		return null;	
	}

	@Override
	public Food findFoodByFoodCode(String foodCode) {
		
		try {
			Food food = sqlSessionTemplate.selectOne("search_mapper.findFoodByFoodCode", foodCode);
			log.debug("SearchDAOImpl findFoodByFoodCode : {}", food);
			return food;
		} catch (Exception e) {
			log.error("SearchDAOImpl findFoodByFoodCode : {}", e.toString());
		}
		
		return null;
	}

	@Override
	public List<Nutrient> findNutrientList() {
		
		try {
			List<Nutrient> nutrientList = sqlSessionTemplate.selectList("search_mapper.findNutrientList");
			log.debug("SearchDAOImpl findNutrientList : {}", nutrientList);
			return nutrientList;
		} catch (Exception e) {
			log.error("SearchDAOImpl findNutrientList : {}", e.toString());
		}
		
		return null;
	}

	

	
	
	
}
