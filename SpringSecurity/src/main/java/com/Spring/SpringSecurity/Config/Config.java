package com.Spring.SpringSecurity.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.Spring.SpringSecurity.Service.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class Config {
	
	@Autowired
	private MyUserDetailsService usd;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception {
		
		http.csrf(customizer->customizer.disable());
		http.authorizeHttpRequests(request->request.anyRequest().authenticated());
		http.formLogin(Customizer.withDefaults());
		http.httpBasic(Customizer.withDefaults());
		
		return http.build();
	}
	
	 

//	@Bean
//	public UserDetailsService USD() {
//		 // Define users with username, password, and roles
//        UserDetails user1 = User.withUsername("user")
//            .password("{noop}password")
//            .roles("USER")
//            .build();
//        
//        UserDetails admin = User.withUsername("admin")
//            .password("{noop}password")
//            .roles("ADMIN")
//            .build();
//
//        // Return an InMemoryUserDetailsManager with the defined users
//        return new InMemoryUserDetailsManager(user1, admin);
//	}
	
	@Bean
	public AuthenticationProvider authenticationprovider() {
		
		DaoAuthenticationProvider DA=new DaoAuthenticationProvider();
		DA.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		DA.setUserDetailsService(usd);
		return DA;
	}

}
