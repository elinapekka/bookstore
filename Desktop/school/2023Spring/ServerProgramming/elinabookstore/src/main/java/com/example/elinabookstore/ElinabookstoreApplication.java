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
	public CommandLineRunner bookstoreDemo(BookRepository repository, CategoryRepository catRepository, UserRepository uRepository) {
		return (args) -> {
			
			catRepository.save(new Category("Thriller"));
			catRepository.save(new Category("Adventure"));
			catRepository.save(new Category("Romance"));
			catRepository.save(new Category("Scifi"));
			catRepository.save(new Category("Fantasy"));
			catRepository.save(new Category("Drama"));
			catRepository.save(new Category("Scientific"));
			catRepository.save(new Category("Coming-of-age"));
			
			repository.save(new Book("Da Vinci Code", "Dan Brown", 2003, "9789524752060", 14.55, catRepository.findByName("Thriller").get(0)));
			repository.save(new Book("Life of Pi", "Yann Martel", 2001, "9789524742367", 12.35, catRepository.findByName("Adventure").get(0)));
			repository.save(new Book("Gone with the Wind", "Margaret Mitchell", 1936, "9759534457163", 16.50, catRepository.findByName("Romance").get(0)));
		
			uRepository.save(new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "user@email.com", "USER"));
			uRepository.save(new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "admin@email.com", "ADMIN"));
		};
	}
}
