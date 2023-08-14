package com.spring.security.apikey.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.spring.security.apikey.config.security.filters.MyCustomFilter;

import lombok.AllArgsConstructor;


@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {
    
    private final  MyCustomFilter myCustomFilter ;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return (
            http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((req) -> 
                    req.anyRequest().authenticated() 
                )
                .addFilterAt(this.myCustomFilter, UsernamePasswordAuthenticationFilter.class) // we add our custom auth filter here 
                .build()  
        );
    }

}