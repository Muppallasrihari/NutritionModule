package com.cg.healthify.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.healthify.beans.NutritionPlan;
import com.cg.healthify.exception.NutritionIdException;
import com.cg.healthify.repository.NutritionPlanRepository;

@Service
public class NutritionPlanServiceImpl implements NutritionPlanService{
	@Autowired
	private NutritionPlanRepository nutritionRepository;
	
	@Override
	public NutritionPlan addOrUpdate(NutritionPlan nutritionPlan) {
		try {
			nutritionPlan.setPlanId(nutritionPlan.getPlanId().toUpperCase());
			return	nutritionRepository.save(nutritionPlan);
		} catch (Exception e) {
			throw new NutritionIdException("Nutrition Plan with id---" + nutritionPlan.getPlanId().toUpperCase() + " ---is already exists.");
		}
		
	}
	@Override
	public Iterable<NutritionPlan> getAllNutritionPlans() {
		return nutritionRepository.findAll();
	}
	@Override
	public NutritionPlan getNutritionPlanById(String planId) {
		NutritionPlan nutritionPlan = nutritionRepository.findByPlanId(planId.toUpperCase());
		if (nutritionPlan == null) {
			throw new NutritionIdException("Nutrition Plan with Id---" + planId.toUpperCase() + " ---does not exists.");
		}
		return nutritionPlan;

	}
	@Override
	public void deleteNutritionPlanById(String planId) {
		NutritionPlan nutritionPlan = nutritionRepository.findByPlanId(planId.toUpperCase());
		if (nutritionPlan == null) {
			throw new NutritionIdException("Nutrition Plan with Id---" + planId.toUpperCase() + " ---does not exists.");
		}
		nutritionRepository.delete(nutritionPlan);
	}
}
