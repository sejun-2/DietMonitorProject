package com.app.controller.search;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.dto.search.Food;
import com.app.dto.search.Page;
import com.app.dto.search.SearchCategory;
import com.app.dto.search.SearchInfo;
import com.app.dto.search.SearchResult;
import com.app.service.search.SearchService;
import com.app.util.page.PageManager;

@Controller
public class SearchController {
	
	@Autowired
	SearchService searchService;
	
	@GetMapping("/foodSearchList")
	public String search(Model model) {
		
		List<SearchCategory> dataSortList = searchService.findDataSortList();		
		model.addAttribute("dataSortList", dataSortList);
		
		List<SearchCategory> mainCategoryList = searchService.findMainCategoryList();		
		model.addAttribute("mainCategoryList", mainCategoryList);		
		
		
		return "search/foodSearchList";
	}
	
	@ResponseBody
	@RequestMapping("/foodSearch")
	public SearchResult foodSearch(@RequestBody SearchInfo searchInfo){
		
		System.out.println(searchInfo);		
		System.out.println(searchInfo.getMainCategoryName());
		System.out.println(searchInfo.getPage().getCurrentPage());
		
		Page page = PageManager.pageCalculate(searchInfo.getPage().getCurrentPage(),
					searchInfo.getPage().getItemsPerPage(), searchService.findFoodTotalItems());
		
		System.out.println(page);	
		
		searchInfo.setPage(page);
		
		List<Food> foodList = searchService.findFoodList(searchInfo);
		
		System.out.println(foodList);
		
		SearchResult searchResult = new SearchResult();
		
		searchResult.setPage(page);
		searchResult.setFoodList(foodList);
		
		return searchResult;
	}
}
