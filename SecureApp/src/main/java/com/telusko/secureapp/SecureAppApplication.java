package com.telusko.secureapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.telusko.secureapp.entities.User;
import com.telusko.secureapp.repository.UserRepository;

@SpringBootApplication
public class SecureAppApplication  implements  CommandLineRunner{
//push jjj
	@Autowired
	private UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(SecureAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//User user1=new User();
		
		//user1.setUsername("akram");
		//user1.setPassword("$2a$10$dOruaCZWi4w4MeBxfG9mm.ZrnAAbTcoBW8OQ4tCb/LeVE9thbNi7a");
		//userRepository.save(user1);
		
		
		
		
	}

}
