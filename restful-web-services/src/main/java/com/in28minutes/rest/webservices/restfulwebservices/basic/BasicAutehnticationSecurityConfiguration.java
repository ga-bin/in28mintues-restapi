package com.in28minutes.rest.webservices.restfulwebservices.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class BasicAutehnticationSecurityConfiguration {

	// filter chain
	// authenticate all requests
	// basic authentication
	// disabling csrf
	// stateless rest api
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> 
									auth
										.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
										.anyRequest().authenticated()
									)
		// default로 login popup창 뜨기 만듬
			.httpBasic(Customizer.withDefaults())
			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.csrf().disable();
		
		return http.build();
	}
}