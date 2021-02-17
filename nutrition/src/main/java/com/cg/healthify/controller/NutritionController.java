package com.cg.healthify.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.healthify.beans.Nutrition;
import com.cg.healthify.service.NutritionService;

@RestController
public class NutritionController {

	@Autowired
	private NutritionService nutritionService;

	@PostMapping("/nutrition")
	public Nutrition addNutritionPlan( @RequestBody Nutrition nutrition) {
		 return nutritionService.addNutritionPlan(nutrition);

	}

	@GetMapping("/nutrition/{id}")
	public Optional<Nutrition> getNutritionPlanByPlanId(@PathVariable Integer id) {

		return nutritionService.getNutritionPlanByPlanId(id);
	}

	@GetMapping("/nutritionplans")
	public List<Nutrition> getAllNutritionPlans() {

		return nutritionService.getAllNutritionPlans();
	}

	@DeleteMapping("/nutrition/{id}")
	public void deleteNutritionPlanById(Integer id) {
		nutritionService.deleteNutritionPlanById(id);

	}

}
