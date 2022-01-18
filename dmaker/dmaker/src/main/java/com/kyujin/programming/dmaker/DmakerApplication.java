package com.kyujin.programming.dmaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DmakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DmakerApplication.class, args);
	}

}
