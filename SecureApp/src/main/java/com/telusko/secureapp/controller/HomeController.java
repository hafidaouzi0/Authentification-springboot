package com.telusko.secureapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	
	
	@RequestMapping("/home")
	public String home(){
		
		return "home.html";
	}

	@RequestMapping("/login")
	public ModelAndView login(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("login.html");
				
		return mv;}
	
	
	@GetMapping("/logout-success")
	public ModelAndView logout(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("logout.html");
				
		return mv;}
	
	
}
