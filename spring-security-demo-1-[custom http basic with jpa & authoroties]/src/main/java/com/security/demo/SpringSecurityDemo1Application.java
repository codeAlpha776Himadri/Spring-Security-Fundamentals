package com.security.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@SpringBootApplication
public class SpringSecurityDemo1Application 
implements CommandLineRunner {

	@Value("${server.port}")
	private final String port ; 

	public static void main(String[] args) {

		/* 
		 *  passwords : 
		 *  himadri  ->  mypass 
		 *  username ->  password
		 */

		SpringApplication.run(SpringSecurityDemo1Application.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		System.out.println("Springboot app running successfully at port:"+this.port+"...");
	}

}
