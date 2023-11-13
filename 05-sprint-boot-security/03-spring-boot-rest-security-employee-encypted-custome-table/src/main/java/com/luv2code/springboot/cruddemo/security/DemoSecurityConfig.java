package com.luv2code.springboot.cruddemo.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

	// Add support for JDBC users.
	@Bean
	public UserDetailsManager userDetailManager(DataSource dataSource) {
		var jdbcUserDetail = new JdbcUserDetailsManager(dataSource);
		jdbcUserDetail.setUsersByUsernameQuery(
				"select user_id, pw, active from members where user_id=?"
				);
		jdbcUserDetail.setAuthoritiesByUsernameQuery(
				"select user_id, role from roles where user_id=?"
				);
		return jdbcUserDetail;
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(configurer -> 
		configurer
		.requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
		.requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
		.requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
		.requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
		.requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN"));
		
		// USE http basic authentication
		http.httpBasic(Customizer.withDefaults());
		
		// disabled cross site request forgery (csrf)
		// in general, no required for stateless rest APIs that use POST, PUT, DELETE and/or PATH
		http.csrf(csrf -> csrf.disable());
		return http.build();
	}
}
