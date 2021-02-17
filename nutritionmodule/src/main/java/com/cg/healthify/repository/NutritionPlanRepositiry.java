package com.cg.healthify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.healthify.beans.NutritionPlan;

@Repository
public interface NutritionPlanRepositiry extends JpaRepository<NutritionPlan,Integer>{

	NutritionPlan findById(String planId);


}
