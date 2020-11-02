package com.leo.hruser.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leo.hruser.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmail(String email);

}
