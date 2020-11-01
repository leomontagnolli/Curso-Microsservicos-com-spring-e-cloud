package com.leo.rhworker.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leo.rhworker.entity.Worker;
import com.leo.rhworker.repository.WorkerRepository;

@RestController
@RequestMapping("/worker")
public class WorkerController {
	
	private static Logger logger = LoggerFactory.getLogger(WorkerController.class);
	
	@Autowired
	private Environment env;
	
	@Autowired
	private WorkerRepository workerRepo;
	
	@GetMapping
	public ResponseEntity<List<Worker>> getAll(){
		return ResponseEntity.ok(workerRepo.findAll());
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Worker> detalhar(@PathVariable Long id){
		Optional<Worker> worker = workerRepo.findById(id);
		logger.info("PORT: " + env.getProperty("local.server.port"));
		
		if(worker.isPresent())
			return ResponseEntity.ok(worker.get());
		
		return ResponseEntity.notFound().build();
		
	}

}
