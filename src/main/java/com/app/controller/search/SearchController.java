package com.app.controller.search;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.dto.search.Food;
import com.app.dto.search.Nutrient;
import com.app.dto.search.Page;
import com.app.dto.search.SearchCategory;
import com.app.dto.search.SearchInfo;
import com.app.dto.search.SearchResult;
import com.app.dto.user.NutritionStandard;
import com.app.service.search.SearchService;
import com.app.service.user.UserService;
import com.app.util.page.PageManager;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SearchController {
	
	@Autowired
	SearchService searchService;
	
	@Autowired
	UserService userService;	
	
	@GetMapping("/foodSearch")
	public String foodSearch(Model model, SearchInfo searchInfo) {
		log.info("음식 검색 페이지 요청");
		
		model.addAttribute("searchInfo", searchInfo);
		
		List<SearchCategory> dataSortList = searchService.findDataSortList();		
		model.addAttribute("dataSortList", dataSortList);
		log.debug("데이터 정렬 리스트: {}", dataSortList);
		
		List<SearchCategory> mainCategoryList = searchService.findMainCategoryList();		
		model.addAttribute("mainCategoryList", mainCategoryList);
		log.debug("메인 카테고리 리스트: {}", mainCategoryList);
		
		return "search/foodSearch";
	}
	
	@ResponseBody
	@RequestMapping("/foodSearchList")
	public SearchResult foodSearchList(@RequestBody SearchInfo searchInfo){
		log.info("음식 검색 결과 요청. 검색 정보: {}", searchInfo);
		Page page = PageManager.pageCalculate(searchInfo.getPage().getCurrentPage(),
					searchInfo.getPage().getItemsPerPage(), searchService.findFoodTotalItems(searchInfo));
		searchInfo.setPage(page);
		log.debug("페이지 정보 계산 완료: {}", page);
		
		List<Food> foodList = searchService.findFoodList(searchInfo);
		log.debug("검색된 음식 리스트: {}", foodList);
		
		SearchResult searchResult = new SearchResult();
		searchResult.setPage(page);
		searchResult.setFoodList(foodList);
		log.info("음식 검색 결과 반환");
		
		return searchResult;
	}
	
	@GetMapping("/foodDetail/{foodCode}")
	public String foodDetail(@PathVariable String foodCode, Model model, HttpSession session) {
		log.info("음식 상세 정보 요청. 음식 코드: {}", foodCode);
		
		Food food = searchService.findFoodByFoodCode(foodCode);
		model.addAttribute("food", food);
		
		List<Nutrient> nutrientList = searchService.findNutrientList();
		log.debug("영양소 리스트: {}", nutrientList);
		model.addAttribute("nutrientList", nutrientList);
		
		List<NutritionStandard> nc = null;
		
		// log...
		//분기
		
		try {
			nc = userService.getNutritionStandardByMemberInfo(session);
			log.debug("영양 기준 정보: {}", nc);
		} catch(NullPointerException e) {
			System.out.println("섹션 오류");
			log.error("세션에서 영양 기준 정보를 가져오는 중 오류 발생", e);
		}
		model.addAttribute("nc", nc);
		
		return "search/foodDetail";
	}
}
