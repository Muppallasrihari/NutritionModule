package com.cg.healthify.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.healthify.beans.Nutrition;

public interface NutritionRepository extends JpaRepository<Nutrition,Integer>{

}
