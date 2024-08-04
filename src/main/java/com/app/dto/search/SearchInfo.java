package com.app.dto.search;

import java.util.List;

import lombok.Data;

@Data
public class SearchInfo {

	String keyword;
	
	String dataSortName;    
   
    List<String> mainCategoryName;
      
    List<String> manufacturingCompany; 
     
    List<String> repFoodName;
   
}
