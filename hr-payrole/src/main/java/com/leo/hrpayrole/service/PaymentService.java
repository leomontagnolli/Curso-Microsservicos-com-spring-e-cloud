package com.leo.hrpayrole.service;

import org.springframework.stereotype.Service;

import com.leo.hrpayrole.entitys.Payment;

@Service
public class PaymentService {
	
	
	public Payment getPayment(long workerId, int days) {
		return new Payment("Leonardo", 200.0, days);
	}

}
