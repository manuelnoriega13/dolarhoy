package com.manoriega.dolarhoy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DolarhoyApplication {

	public static void main(String[] args) {
		SpringApplication.run(DolarhoyApplication.class, args);
	}
}
