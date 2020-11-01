package com.leo.hrpayrole.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leo.hrpayrole.entitys.Payment;
import com.leo.hrpayrole.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/payments")
public class PaymentController {
	
	@Autowired
	private PaymentService service;
	
	@HystrixCommand(fallbackMethod = "getPaymentAlternative")
	@GetMapping("/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable long workerId, @PathVariable Integer days){
		Payment pagamento = service.getPayment(workerId, days);
		return ResponseEntity.ok(pagamento);
	}
	
	public ResponseEntity<Payment> getPaymentAlternative( long workerId, Integer days){
		Payment pagamento = new Payment("Leo", 400.0, days);
		return ResponseEntity.ok(pagamento);
	}
	
	

}
