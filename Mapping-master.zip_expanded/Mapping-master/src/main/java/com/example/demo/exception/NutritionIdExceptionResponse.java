package com.example.demo.exception;

public class NutritionIdExceptionResponse {

	private String planId;

	
	public NutritionIdExceptionResponse(String planId) {
		super();
		this.planId = planId;
	}

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}
	
}
