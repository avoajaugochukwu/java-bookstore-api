package com.ugochukwu.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.ugochukwu.bookstore.config.APIProperties;

@EnableConfigurationProperties(APIProperties.class)
@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	// public CommandLineRunner run(DataLoader dataLoader) {
	// 	return args -> {
	// 		dataLoader.run();
	// 	};
	// }
}
