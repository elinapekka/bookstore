package com.example.elinabookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.elinabookstore.model.Category;
import com.example.elinabookstore.model.CategoryRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CategoryRepositoryTest {
	@Autowired
	private CategoryRepository repository;
	
	@Test
	public void createNewCategory() {
		Category category = new Category("Mystery");
		
		repository.save(category);
		assertThat(category.getId()).isNotNull();
	}
	
	@Test
	public void deleteCategory() {
		List<Category> categories = repository.findByName("Scientific");
		Category category = categories.get(0);
		
		repository.delete(category);
		List<Category> newCategories = repository.findByName("Scientific");
		assertThat(newCategories).hasSize(0);
	}
	
	@Test
	public void findByNameShouldReturnCateogry() {
		List<Category> categories = repository.findByName("Adventure");
		
		assertThat(categories).hasSize(1);
	}
}
