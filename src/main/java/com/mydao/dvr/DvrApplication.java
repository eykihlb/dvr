package com.mydao.dvr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DvrApplication {

	public static void main(String[] args) {

		SpringApplication.run(DvrApplication.class, args);
	}

}

