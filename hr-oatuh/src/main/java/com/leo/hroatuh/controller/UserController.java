package com.leo.hroatuh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leo.hroatuh.entities.User;
import com.leo.hroatuh.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/search")
	public ResponseEntity<User> getUserByEmail(@RequestParam String email){
		try {
			User user = service.buscaUsuarioEmail(email);
			return ResponseEntity.ok(user);
		}
		catch (IllegalArgumentException ex) {
			return ResponseEntity.notFound().build();
		}
		
	}

}
