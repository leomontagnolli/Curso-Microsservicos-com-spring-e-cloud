package com.leo.hroatuh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class HrOatuhApplication implements CommandLineRunner {
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	public static void main(String[] args) {
		SpringApplication.run(HrOatuhApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("senha: " + encoder.encode("123456"));
		
	}

}
