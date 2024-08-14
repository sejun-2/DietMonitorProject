package com.app.util;

import java.util.ArrayList;
import java.util.List;

import com.app.dto.diet.Diet;

public class NutritionCalculator {
	
	private static final double NO_REC_OR_MAX_INTAKE = 9999;
	
	public static List<Double> calculateStandardMinusTotalIntake(List<Double> recommendedIntake, 
															Diet totalNutrient){
		List<Double> calculatedNutrients = new ArrayList<Double>();
		
		calculatedNutrients.add(totalNutrient.getKcal()-recommendedIntake.get(0));
		calculatedNutrients.add(totalNutrient.getWater()-recommendedIntake.get(1));
		calculatedNutrients.add(totalNutrient.getProtein()-recommendedIntake.get(2));
		calculatedNutrients.add(totalNutrient.getFat()-recommendedIntake.get(3));
		calculatedNutrients.add(totalNutrient.getCarbohydrate()-recommendedIntake.get(4));
		calculatedNutrients.add(totalNutrient.getSugars()-recommendedIntake.get(5));
		calculatedNutrients.add(totalNutrient.getDietaryFiber()-recommendedIntake.get(6));
		calculatedNutrients.add(totalNutrient.getCalcium()-recommendedIntake.get(7));
		calculatedNutrients.add(totalNutrient.getIronContent()-recommendedIntake.get(8));
		calculatedNutrients.add(totalNutrient.getPhosphorus()-recommendedIntake.get(9));
		calculatedNutrients.add(totalNutrient.getPotassium()-recommendedIntake.get(10));
		calculatedNutrients.add(totalNutrient.getSodium()-recommendedIntake.get(11));
		calculatedNutrients.add(totalNutrient.getVitaminA()-recommendedIntake.get(12));
		calculatedNutrients.add(NO_REC_OR_MAX_INTAKE);
		calculatedNutrients.add(NO_REC_OR_MAX_INTAKE);
		calculatedNutrients.add(totalNutrient.getThiamine()-recommendedIntake.get(15));
		calculatedNutrients.add(totalNutrient.getRiboflavin()-recommendedIntake.get(16));
		calculatedNutrients.add(totalNutrient.getNiacin()-recommendedIntake.get(17));
		calculatedNutrients.add(totalNutrient.getVitaminC()-recommendedIntake.get(18));
		calculatedNutrients.add(totalNutrient.getVitaminD()-recommendedIntake.get(19));
		calculatedNutrients.add(totalNutrient.getCholesterol()-recommendedIntake.get(20));
		calculatedNutrients.add(totalNutrient.getSaturatedFat()-recommendedIntake.get(21));
		calculatedNutrients.add(totalNutrient.getTransFat()-recommendedIntake.get(22));
		
//		List<int> 영양소별상태 = new ArrayList<int>();
//		for(int i=0; i<calculatedNutrients.size(); i++) {
//			
//			if(recommendedIntake.get(i) == NO_REC_OR_MAX_INTAKE) {
//				영양소별상태.add(3);
//			} else {
//				if( calculatedNutrients.get(i) > recommendedIntake.get(i)*0.3 ) {
//					영양소별상태.add(2);
//				} else if( calculatedNutrients.get(i) < recommendedIntake.get(i)*0.3 ) {
//					영양소별상태.add(1);
//				} else {
//					영양소별상태.add(3);
//				}
//			}
//			calculatedNutrients.get(i) == NO_REC_OR_MAX_INTAKE ? 0: 0;
//		}
		
		return calculatedNutrients;
	}
	
}