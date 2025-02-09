package com.br.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
		info = @Info(
				title = "Book Service API",
				version = "1.0",
				description = "Project: Library Management"
		)
)




@SpringBootApplication
public class BookApplication {

	public static void main(String[] args) {

		SpringApplication.run(BookApplication.class, args);
	}

}
