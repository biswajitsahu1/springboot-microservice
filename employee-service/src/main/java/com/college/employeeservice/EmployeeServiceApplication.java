package com.college.employeeservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@OpenAPIDefinition(
		info = @Info(
				title = "Employee Service RestApi",
				description = "Employee Service RestApi Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Biswajit",
						email="biswajit@gmail.com",
						url="http://www.keepLearning.in"
				),
				license = @License(
						name = "Apache 2.0",
						url="http://apache2.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Employee-service doc",
				url = "http://Employee-service.com"
		)
)
@SpringBootApplication
public class EmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
