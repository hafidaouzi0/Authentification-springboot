package com.telusko.secureapp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity(name="users")
@Table(name="users")
public class User {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private  Long  id;
	
	
	private String username;

	private String password;
	
	
	
}
