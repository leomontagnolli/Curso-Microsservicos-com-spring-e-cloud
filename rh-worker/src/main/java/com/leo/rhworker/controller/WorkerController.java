package com.leo.rhworker.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	private WorkerRepository workerRepo;
	
	@GetMapping
	public ResponseEntity<List<Worker>> getAll(){
		return ResponseEntity.ok(workerRepo.findAll());
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Worker> detalhar(@PathVariable Long id){
		Optional<Worker> worker = workerRepo.findById(id);
		
		if(worker.isPresent())
			return ResponseEntity.ok(worker.get());
		
		return ResponseEntity.notFound().build();
		
	}

}
