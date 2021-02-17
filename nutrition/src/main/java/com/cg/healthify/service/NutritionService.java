package com.cg.healthify.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cg.healthify.beans.Nutrition;

@Service
public interface NutritionService {

	

	Nutrition addNutritionPlan(Nutrition nutrition);

	Optional<Nutrition> getNutritionPlanByPlanId(Integer id);

	List<Nutrition> getAllNutritionPlans();

	void deleteNutritionPlanById(Integer id);

	

}
