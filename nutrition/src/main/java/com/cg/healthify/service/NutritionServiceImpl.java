package com.cg.healthify.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cg.healthify.beans.Nutrition;
import com.cg.healthify.repository.NutritionRepository;

@Service
public class NutritionServiceImpl implements NutritionService {

	private NutritionRepository nutritionRepository;
	

	@Override
	public Nutrition addNutritionPlan(Nutrition nutrition) {
		return nutritionRepository.save(nutrition);
		
	}


	@Override
	public Optional<Nutrition> getNutritionPlanByPlanId(Integer id) {
		return nutritionRepository.findById(id);
	}


	@Override
	public List<Nutrition> getAllNutritionPlans() {
		return nutritionRepository.findAll();
	}


	@Override
	public void deleteNutritionPlanById(Integer id) {
		 nutritionRepository.deleteById(id);
		 
	}
	

}
