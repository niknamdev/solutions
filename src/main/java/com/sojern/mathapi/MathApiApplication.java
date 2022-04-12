package com.sojern.mathapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.sojern.mathapi")
public class MathApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MathApiApplication.class, args);
	}

}
