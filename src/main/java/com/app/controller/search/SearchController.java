package com.app.controller.search;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.dto.search.Food;
import com.app.dto.search.SearchCategory;
import com.app.service.search.SearchService;

@Controller
public class SearchController {
	
	@Autowired
	SearchService searchService;
	
	@GetMapping("/search")
	public String search(Model model) {
		
		List<SearchCategory> dataSortList = searchService.findDataSortList();
		
		model.addAttribute("dataSortList", dataSortList);
		
		
		List<SearchCategory> mainCategoryList = searchService.findMainCategoryList();
		
		model.addAttribute("mainCategoryList", mainCategoryList);
		
		List<Food> foodList = searchService.findFoodList();
		
		model.addAttribute("foodList", foodList);
		
		return "search/searchPage";
	}
	
}
