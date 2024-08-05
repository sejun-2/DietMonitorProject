package com.app.service.search.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.search.SearchDAO;
import com.app.dto.search.Food;
import com.app.dto.search.Page;
import com.app.dto.search.SearchCategory;
import com.app.dto.search.SearchInfo;
import com.app.service.search.SearchService;

@Service
public class SearchServiceImpl implements SearchService{

	@Autowired
	SearchDAO searchDAO;

	@Override
	public List<SearchCategory> findDataSortList() {
		
		List<SearchCategory> searchCategoryList = searchDAO.findDataSortList();
		
		return searchCategoryList;
	}
	
	@Override
	public List<SearchCategory> findMainCategoryList() {
		
		List<SearchCategory> searchCategoryList = searchDAO.findMainCategoryList();
		
		return searchCategoryList;
	}
	
	@Override
	public int findFoodTotalItems() {
		
		int foodTotalItems = searchDAO.findFoodTotalItems();
		
		return foodTotalItems;
	}
	
	
	@Override
	public List<Food> findFoodList(SearchInfo searchInfo) {
		
		System.out.println("service");
		System.out.println(searchInfo);
		
		List<Food> FoodList = searchDAO.findFoodList(searchInfo);
		
		return FoodList;
	}

	

	
	
	
}
