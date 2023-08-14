package com.security.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) 
    throws Exception 
    {
        return (
            http
            .csrf(csrf -> csrf.disable())
            .cors(Customizer.withDefaults())
            .authorizeHttpRequests((authz) ->  
                authz.requestMatchers(AntPathRequestMatcher.antMatcher("/api/demo1")).permitAll()
                     .anyRequest().authenticated()
            )
            .httpBasic(Customizer.withDefaults())
            .build() 
        );
    } 


    @Bean 
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10) ;
    }


}
