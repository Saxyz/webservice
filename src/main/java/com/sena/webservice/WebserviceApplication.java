package com.sena.webservice;

import com.sena.webservice.dto.UserDTO;
import com.sena.webservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebserviceApplication implements CommandLineRunner {
	UserService userService;

	@Autowired
	public WebserviceApplication(UserService userService) {
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(WebserviceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
