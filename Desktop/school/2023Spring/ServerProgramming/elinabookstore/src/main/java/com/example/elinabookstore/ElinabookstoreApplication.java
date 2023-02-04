package com.example.elinabookstore;

import org.springframework.boot.CommandLineRunner;
import com.example.elinabookstore.model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ElinabookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElinabookstoreApplication.class, args);
	}
	
	
	@Bean
	public CommandLineRunner bookstoreDemo(BookRepository repository) {
		return (args) -> {
			repository.save(new Book("Da Vinci Code", "Dan Brown", 2003, "9789524752060", 14.55));
			repository.save(new Book("Life of Pi", "Yann Martel", 2001, "9789524742367", 12.35));
			repository.save(new Book("Gone with the Wind", "Margaret Mitchell", 1936, "9759534457163", 16.50));
		};
	}
}
