package com.genuinecoder.learnspringsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	@Autowired
	private MyUserDetailService userDetailService;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
	return	httpSecurity
			.csrf(httpSecurityCsrfConfigurer->httpSecurityCsrfConfigurer.disable())
			.authorizeHttpRequests(registry->{
			registry.requestMatchers("/home","/register/**").permitAll();
			registry.requestMatchers("/admin/**").hasRole("ADMIN");
			registry.requestMatchers("/user/**").hasRole("USER");
			registry.anyRequest().authenticated();
		})
			.formLogin(httpSecurityFormLoginConfigurer ->{
				httpSecurityFormLoginConfigurer.loginPage("/login").successHandler(new AuthenticationSuccessHandler()).permitAll();
			})
		.build();
	}
	
//	@Bean
//	public UserDetailsService userDetailsService() {
//		UserDetails normalUser = User.builder()
//				.username("gc")
//				.password("$2a$12$NgFQNWhtrR2tSPuOqV9RhO/pJ5DwMFhXCSm1R/V3GpB//nrRgWm3G")
//				.roles("USER")
//				.build();
//		
//		UserDetails adminUser = User.builder()
//				.username("admin")
//				.password("$2a$12$XbpXccW0ORPxnjAtv5Tm0.57o4O/EkQTLjBrKGJG8urKgRCOoqZGC")
//				.roles("ADMIN","USER")
//				.build();
//		
//		return new InMemoryUserDetailsManager(normalUser,adminUser);
//	}
	@Bean
	public UserDetailsService userDetailsService() {
		return userDetailService;
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailService);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}
	
	@Bean 
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	

}
