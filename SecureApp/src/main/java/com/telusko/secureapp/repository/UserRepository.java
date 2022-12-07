package com.telusko.secureapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telusko.secureapp.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findUserByUsername(String username);

}
