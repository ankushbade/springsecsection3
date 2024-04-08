package com.example.bank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig 
{
	 @Bean
	    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

	        /**
	         *  Below is the custom security configurations
	         */

	        http.authorizeHttpRequests((requests) -> requests.requestMatchers("/myAccount","/myBalance","/myLoans","/myCards").authenticated()
	                        .requestMatchers("/notices","/contact").permitAll())
	                .formLogin(Customizer.withDefaults())
	                .httpBasic(Customizer.withDefaults());
	        return http.build();
	        
	        /*http.authorizeHttpRequests().requestMatchers("/myAccount","/myBalance","/myLoans","/myCards").authenticated()
			        .requestMatchers("/notices","/contact").permitAll()
			        .and().formLogin()
			        .and().httpBasic();
			  return http.build();
	         */

	      
	    }
}
