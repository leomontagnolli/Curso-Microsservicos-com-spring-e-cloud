package com.leo.hruser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leo.hruser.entities.User;
import com.leo.hruser.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository repository;
	
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User user = repository.findById(id).get();
		return ResponseEntity.ok(user);
		
	}
	
	@GetMapping("/search")
	public ResponseEntity<User> findByemail(@RequestParam String email){
		System.out.println("AQUi");
		User user = repository.findByEmail(email);
		return ResponseEntity.ok(user);
		
	}

}
