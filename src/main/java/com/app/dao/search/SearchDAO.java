package com.app.dao.search;

import java.util.List;

import com.app.dto.search.Food;
import com.app.dto.search.SearchCategory;

public interface SearchDAO {

	public List<SearchCategory> findDataSortList();
	
	public List<SearchCategory> findMainCategoryList();
	
	public List<Food> findFoodList();
	
}
