package com.pos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.pos")
public class PosApplication {

	public static void main(String[] args) {
		SpringApplication.run(PosApplication.class, args);
		System.out.print("Hello");
	}

}
