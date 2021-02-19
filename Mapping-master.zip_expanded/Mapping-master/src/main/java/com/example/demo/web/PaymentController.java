package com.example.demo.web;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import com.example.demo.domain.DietPlan;
import com.example.demo.domain.Payment;
import com.example.demo.service.PaymentService;
import com.example.demo.service.ValidationService;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
@Autowired
private PaymentService paymentService;
@Autowired
private ValidationService validationService;

@PostMapping("/{paymentIdentifier}")
public ResponseEntity<?> addAndUpdatePayment(@Valid @RequestBody Payment payment,BindingResult result,@PathVariable String paymentIdentifier){
	ResponseEntity<?> errorMsg=validationService.validationError(result);
	if(errorMsg!=null) return errorMsg;	
	Payment payment1=paymentService.addPayment(paymentIdentifier, payment);
	return new ResponseEntity<Payment>(payment1,HttpStatus.OK);
}

	@GetMapping("/{transactionId}")
	public Payment getPaymentDetails(@PathVariable String transactionId){ 
		return paymentService.findPaymentByTransactionId(transactionId);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> DeletePaymentById(@PathVariable Long id){
		 paymentService.deletePaymentByTransactionId(id);
		return new ResponseEntity<String>("Payment having Transaction ID: "+id+" is deleted.",HttpStatus.OK);
	}
	}
