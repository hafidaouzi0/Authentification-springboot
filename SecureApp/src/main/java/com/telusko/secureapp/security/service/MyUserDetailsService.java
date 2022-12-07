package com.telusko.secureapp.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.telusko.secureapp.entities.User;
import com.telusko.secureapp.repository.UserRepository;
import com.telusko.secureapp.security.UserDetailsIpml;


@Service
public class MyUserDetailsService  implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	User user=userRepository.findUserByUsername(username);
	
	if(user==null)
		throw new UsernameNotFoundException("User Not FOUND");
		return new UserDetailsIpml(user);
	}

}
