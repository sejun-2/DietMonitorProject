package com.app.dao.search.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.search.SearchDAO;
import com.app.dto.search.Food;
import com.app.dto.search.Page;
import com.app.dto.search.SearchCategory;

@Repository
public class SearchDAOImpl implements SearchDAO{

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<SearchCategory> findDataSortList() {
		
		List<SearchCategory> searchCategoryList = sqlSessionTemplate.selectList("search_mapper.findDataSortList");
		
		return searchCategoryList;
	}
	
	@Override
	public List<SearchCategory> findMainCategoryList() {
		
		List<SearchCategory> searchCategoryList = sqlSessionTemplate.selectList("search_mapper.findMainCategoryList");
		
		return searchCategoryList;
	}
	
	@Override
	public int findFoodTotalItems() {
		
		int foodTotalItems = sqlSessionTemplate.selectOne("search_mapper.findfoodTotalItems");
		
		return foodTotalItems;
	}
	
	@Override
	public List<Food> findFoodList(Page page) {
		
		System.out.println("dao");
		System.out.println(page);
		
		List<Food> FoodList = sqlSessionTemplate.selectList("search_mapper.findFoodList", page);
		System.out.println(FoodList);
		return FoodList;
	}

	

	
	
	
}
