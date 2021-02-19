package com.example.demo.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.NutritionPlan;
import com.example.demo.service.MapValidationErrorService;
import com.example.demo.service.NutritionPlanService;



@RestController
public class NutritionPlanController {
	@Autowired
	private NutritionPlanService nutritionPlanService;
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	@PostMapping("/nutritionplan")
	public ResponseEntity<?> addNutritionPlan(@Valid @RequestBody NutritionPlan nutritionPlan, BindingResult result) {
		
		ResponseEntity<?> errorMap=mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null) {
			return errorMap;
		}
		NutritionPlan plan=nutritionPlanService.addOrUpdate(nutritionPlan);
		return new ResponseEntity<NutritionPlan>(plan,HttpStatus.OK);
	}
	
	
	@GetMapping("/nutritionplan/{planId}")
	public ResponseEntity<NutritionPlan> getNutritionPlanById(@PathVariable String planId){
		NutritionPlan nutritionPlan=nutritionPlanService.getNutritionPlanById(planId);
		return new ResponseEntity<NutritionPlan>(nutritionPlan,HttpStatus.OK);
	}
	
	@GetMapping("/allnutritionplans")
	public Iterable<NutritionPlan> getAllNutritionPlans(){
		return nutritionPlanService.getAllNutritionPlans();
	}
	
	@DeleteMapping("/nutritionplan/{planId}")
	public ResponseEntity<?> deleteNutritionPlanById(@PathVariable String planId) {
		nutritionPlanService.deleteNutritionPlanById(planId);
		return new ResponseEntity<String>("Nutrition Plan with Id "+planId+" deleted successfully", HttpStatus.OK);
	}
	

}
