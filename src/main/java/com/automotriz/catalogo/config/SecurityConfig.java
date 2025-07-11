package com.automotriz.catalogo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableGlobalMethodSecurity(securedEnabled = true)
@EnableWebSecurity
@Configuration
public class SecurityConfig {

	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailsService() {

		PasswordEncoder encoder = passwordEncoder();

		UserDetails user = User.builder().passwordEncoder(encoder::encode)
				.username("CristianC")
				.password("1234")
				.roles("USER")
				.build();
		UserDetails admin = User.builder().passwordEncoder(encoder::encode)
				.username("MarcosM")
				.password("1234")
				.roles("ADMIN", "USER")
				.build();
		return new InMemoryUserDetailsManager(user, admin);
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.authorizeRequests(requests -> requests
						.antMatchers("/css/**", "/js/**", "/images/**", "/h2-console/**").permitAll()
						.anyRequest().hasRole("USER"))
				.formLogin(login -> login.loginPage("/login").permitAll())
				.logout(logout -> logout.permitAll());

		// ************* USED FOR ACCESSING THE H2 CONSOLE WITH SPRING SECURITY
		// ************* REMOVE IN PRODUCTION!
		http.csrf(csrf -> csrf.disable());
		http.headers(headers -> headers.frameOptions().disable());
		// *************

		return http.build();
	}

}
