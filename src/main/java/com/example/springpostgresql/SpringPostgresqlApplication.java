package com.example.springpostgresql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SpringPostgresqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPostgresqlApplication.class, args);
	}

}
