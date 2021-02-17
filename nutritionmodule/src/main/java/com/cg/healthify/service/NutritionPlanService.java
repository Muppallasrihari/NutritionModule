package com.cg.healthify.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.healthify.beans.NutritionPlan;
import com.cg.healthify.exception.NutritionIdException;
import com.cg.healthify.repository.NutritionPlanRepositiry;

@Service
public class NutritionPlanService {
	@Autowired
	private NutritionPlanRepositiry nutritionRepository;

	public NutritionPlan addOrUpdate(NutritionPlan nutritionPlan) {
		try {
			nutritionPlan.setPlanId(nutritionPlan.getPlanId().toUpperCase());
			return nutritionRepository.save(nutritionPlan);
		} catch (Exception e) {
			throw new NutritionIdException("NUtrition Plan with :" + nutritionPlan.getPlanId() + " is already exists.");
		}
	}

	public Iterable<NutritionPlan> getAllNutritionPlans() {
		return nutritionRepository.findAll();
	}

	public NutritionPlan getNutritionPlanById(String planId) {
		NutritionPlan nutritionPlan = nutritionRepository.findById(planId.toUpperCase());
		if (nutritionPlan == null) {
			throw new NutritionIdException("Nutrition Plan with :" + planId.toUpperCase() + " does not exists.");
		}
		return nutritionPlan;

	}
	
	public void deleteNutritionPlanById(String planId) {
		NutritionPlan nutritionPlan = nutritionRepository.findById(planId.toUpperCase());
		if (nutritionPlan == null) {
			throw new NutritionIdException("Nutrition Plan with :" + planId.toUpperCase() + " does not exists.");
		}
		nutritionRepository.delete(nutritionPlan);
	}
}
