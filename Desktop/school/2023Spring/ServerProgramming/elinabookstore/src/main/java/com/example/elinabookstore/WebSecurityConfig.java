package com.example.elinabookstore;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true) // https://docs.spring.io/spring-security/reference/servlet/authorization/method-security.html
public class WebSecurityConfig {
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http
		.authorizeHttpRequests().requestMatchers("/css/**").permitAll()
		.and()
		.authorizeHttpRequests().anyRequest().authenticated()
		.and()
		.headers().frameOptions().disable()
		.and()
		.formLogin().loginPage("/login").loginProcessingUrl("/login").defaultSuccessUrl("/booklist", true).permitAll()
		.and()
		.logout().permitAll();
		
		return http.build();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		List<UserDetails> users = new ArrayList<UserDetails>();

		PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

		UserDetails user = User
				.withUsername("user")
				.password(passwordEncoder.encode("user"))
				.roles("USER")
				.build();

		users.add(user);

		user = User
				.withUsername("admin")
				.password(passwordEncoder.encode("admin"))
				.roles("ADMIN")
				.build();

		users.add(user);

		return new InMemoryUserDetailsManager(users);
	}
}
