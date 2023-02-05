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
	public CommandLineRunner bookstoreDemo(BookRepository repository, CategoryRepository catRepository) {
		return (args) -> {
			
			catRepository.save(new Category("Thriller"));
			catRepository.save(new Category("Adventure"));
			catRepository.save(new Category("Romance"));
			catRepository.save(new Category("Scifi"));
			catRepository.save(new Category("Fantasy"));
			catRepository.save(new Category("Drama"));
			catRepository.save(new Category("Scientific"));
			
			repository.save(new Book("Da Vinci Code", "Dan Brown", 2003, "9789524752060", 14.55, catRepository.findByName("Thriller").get(0)));
			repository.save(new Book("Life of Pi", "Yann Martel", 2001, "9789524742367", 12.35, catRepository.findByName("Adventure").get(0)));
			repository.save(new Book("Gone with the Wind", "Margaret Mitchell", 1936, "9759534457163", 16.50, catRepository.findByName("Romance").get(0)));
		};
	}
}
