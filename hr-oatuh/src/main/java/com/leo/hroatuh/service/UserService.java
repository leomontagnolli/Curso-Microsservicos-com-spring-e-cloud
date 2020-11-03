package com.leo.hroatuh.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.leo.hroatuh.clients.UserFeignClient;
import com.leo.hroatuh.entities.User;

@Service
public class UserService implements UserDetailsService {
	
	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserFeignClient userClient;
	
	public User buscaUsuarioEmail(String email) {
		User user = userClient.findByemail(email).getBody();
		
		if(user == null) {
			logger.error("Email not found " + email);
			throw new IllegalArgumentException();
		}
		logger.info("Achou " +  email);
		return user;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userClient.findByemail(email).getBody();
		
		if(user == null) {
			logger.error("Email not found " + email);
			throw new UsernameNotFoundException("Not found");
		}
		logger.info("Achou " +  email);
		return user;
	}

}
