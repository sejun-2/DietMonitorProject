package com.app.dao.search;

import java.util.List;

import com.app.dto.search.Food;
import com.app.dto.search.Page;
import com.app.dto.search.SearchCategory;
import com.app.dto.search.SearchInfo;

public interface SearchDAO {

	public List<SearchCategory> findDataSortList();
	
	public List<SearchCategory> findMainCategoryList();
	
	public int findFoodTotalItems();
	
	public List<Food> findFoodList(SearchInfo searchInfo);
	
}
