package com.telusko.secureapp.security;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.weaver.ast.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.AntPathMatcher;

import jakarta.servlet.Filter;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig  {

	@Autowired
	private UserDetailsService userDetailsService;

	
	//we use this to fetch data from the database
   @Bean
   public AuthenticationProvider authProvider() {
	
	DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
	//userDetailsService is responsible to fetch data from database
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		//we use this line to not encode our password ,use it in plain text
		//provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return provider;
		
	}
   

   
   
 @Bean
 public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	
	 
	 
	 http
			 .cors()
			 .and().csrf().disable()
			 .authorizeHttpRequests(authorizeConfig ->{
		//authorizeConfig.requestMatchers("/").permitAll();
		 authorizeConfig.anyRequest().authenticated();
		 
	 }).formLogin()
			 .loginPage("/login").permitAll()
			 .defaultSuccessUrl("/home",true)
			 .and().httpBasic().and() .logout().invalidateHttpSession(true)
			  .clearAuthentication(true).logoutRequestMatcher(new
					  AntPathRequestMatcher("/logout")) 
					  .logoutSuccessUrl("/logout-success").permitAll()
			 ;
			 
			
	 return http.build();
	 
	 
 }

   
 
 
	/*
	 * http .cors() .and().csrf().disable() .authorizeHttpRequests(authorizeConfig
	 * ->{ //authorizeConfig.requestMatchers("/").permitAll();
	 * authorizeConfig.anyRequest().authenticated();
	 * 
	 * }).formLogin() .loginPage("/login").permitAll() .defaultSuccessUrl("/")
	 * .and().httpBasic().and() .logout().invalidateHttpSession(true)
	 * .clearAuthentication(true).logoutRequestMatcher(new
	 * AntPathRequestMatcher("/logout")) //
	 * .logoutSuccessUrl("/logout-success").permitAll();
	 */


	/*
	 * @Bean public SecurityFilterChain filterChain(HttpSecurity http) throws
	 * Exception {
	 * 
	 * http
	 * 
	 * .authorizeRequests() .requestMatchers("/sa/abc/**").an
	 * .antMatchers("/sa/practices/**").hasAnyAuthority("ADMIN")
	 * .antMatchers("/sa/**").authenticated();
	 * 
	 * // http // .csrf().disable() // .authorizeHttpRequests() //
	 * .anyRequest().authenticated() // .and() // .formLogin() //
	 * .loginPage("/login").permitAll() // .defaultSuccessUrl("/") //
	 * .and().httpBasic().and() // .logout().invalidateHttpSession(true) //
	 * .clearAuthentication(true) // .logoutRequestMatcher(new
	 * AntPathRequestMatcher("/logout")) //
	 * .logoutSuccessUrl("/logout-success").permitAll();
	 * 
	 * }
	 */
	
	
	
	//in memory authentification
	/*
	 * @Bean public InMemoryUserDetailsManager userDetailsService() {
	 * List<UserDetails> user = new ArrayList<>();
	 * user.add(User.withDefaultPasswordEncoder() .username("user")
	 * .password("password") .roles("USER") .build());
	 * user.add(User.withDefaultPasswordEncoder() .username("hafida")
	 * .password("hafida") .roles("USER") .build()); return new
	 * InMemoryUserDetailsManager(user); }
	 */
	
	
}
