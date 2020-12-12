package com.faculdade.diarista;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class DiaristaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiaristaApplication.class, args);
	}

}
