package com.leo.hrpayrole.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.leo.hrpayrole.entitys.Payment;
import com.leo.hrpayrole.entitys.Worker;

@Service
public class PaymentService {
	
	@Value("${hr-worker.url}")
	private String workerHost;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	public Payment getPayment(long workerId, int days) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", String.valueOf(workerId));
		
		
		Worker worker = restTemplate.getForObject(workerHost + "/worker/{id}", Worker.class, uriVariables);
		
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}

}
