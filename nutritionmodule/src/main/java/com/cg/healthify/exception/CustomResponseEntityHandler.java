package com.cg.healthify.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseEntityHandler extends ResponseEntityExceptionHandler {

	public ResponseEntity<Object> handleNutritionIdException(NutritionIdException ex){
		NutritionIdExceptionResponse nutritionIdExceptionResponse=new NutritionIdExceptionResponse(ex.getMessage());
		return new ResponseEntity<Object> (nutritionIdExceptionResponse,HttpStatus.BAD_REQUEST);
	}
}
     