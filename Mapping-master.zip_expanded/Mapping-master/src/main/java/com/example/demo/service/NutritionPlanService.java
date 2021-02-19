package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.domain.NutritionPlan;



@Service
public interface NutritionPlanService {
	public NutritionPlan addOrUpdate(NutritionPlan nutritionPlan);
	public Iterable<NutritionPlan> getAllNutritionPlans();
	public NutritionPlan getNutritionPlanById(String planId);
	public void deleteNutritionPlanById(String planId);
}
