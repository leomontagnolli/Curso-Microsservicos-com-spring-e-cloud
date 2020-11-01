package com.leo.hrpayrole.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leo.hrpayrole.clients.WorkerFeignClient;
import com.leo.hrpayrole.entitys.Payment;
import com.leo.hrpayrole.entitys.Worker;

@Service
public class PaymentService {

	@Autowired
	private WorkerFeignClient workerClient;
	
	
	public Payment getPayment(long workerId, int days) {

		
		
		Worker worker = workerClient.detalhar(workerId).getBody();
		
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}

}
