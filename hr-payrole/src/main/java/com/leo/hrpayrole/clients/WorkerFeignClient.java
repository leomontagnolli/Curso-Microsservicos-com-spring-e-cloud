package com.leo.hrpayrole.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.leo.hrpayrole.entitys.Worker;

@Component
@FeignClient(name = "hr-worker", path = "/worker")
public interface WorkerFeignClient {
	

	@GetMapping("/{id}")
	ResponseEntity<Worker> detalhar(@PathVariable Long id);
	
	
}
