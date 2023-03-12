package com.example.elinabookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.elinabookstore.model.Book;
import com.example.elinabookstore.model.BookRepository;
import com.example.elinabookstore.model.CategoryRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository crepository;
	
	@Test
	public void createNewBook() {
		Book book = new Book("Catcher in the Rye", "J.D. Salinger", 1951, "9349524152360", 12.30, crepository.findByName("Coming-of-age").get(0));
		
		repository.save(book);
		assertThat(book.getId()).isNotNull();
	}
	
	@Test
	public void deleteBook() {
		List<Book> books = repository.findByTitle("Gone with the Wind");
		Book book = books.get(0);
		
		repository.delete(book);
		List<Book> newBooks = repository.findByTitle("Gone with the Wind");
		assertThat(newBooks).hasSize(0);
	}
	
	@Test
	public void findByTitleShouldReturnBook() {
		List<Book> books = repository.findByTitle("Life of Pi");
		
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("Yann Martel");
	}
}
