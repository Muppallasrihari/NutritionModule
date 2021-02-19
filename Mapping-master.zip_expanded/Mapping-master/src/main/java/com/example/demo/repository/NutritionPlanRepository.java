package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.NutritionPlan;


@Repository
public interface NutritionPlanRepository extends CrudRepository<NutritionPlan,Integer>{

	NutritionPlan findByPlanId(String planId);

	


}
