package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

	@Bean
	public InMemoryUserDetailsManager userDetailManafer() {
		UserDetails atif = User.builder()
				.username("atif")
				.password("{noop}test123")
				.roles("EMPLOYEE")
				.build();
		
		UserDetails hira = User.builder()
				.username("hira")
				.password("{noop}test123")
				.roles("EMPLOYEE", "MANAGER")
				.build();
		
		UserDetails ammi = User.builder()
				.username("ammi")
				.password("{noop}test123")
				.roles("EMPLOYEE", "MANAGER", "ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(atif, hira, ammi);
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(configurer -> 
		configurer
		.requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
		.requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
		.requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
		.requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
		.requestMatchers(HttpMethod.DELETE, "/api/employees").hasRole("ADMIN"));
		
		// USE http basic authentication
		http.httpBasic(Customizer.withDefaults());
		
		// disabled cross site request forgery (csrf)
		// in general, no required for stateless rest APIs that use POST, PUT, DELETE and/or PATH
		http.csrf(csrf -> csrf.disable());
		return http.build();
	}
}
