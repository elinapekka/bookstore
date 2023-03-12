package com.example.elinabookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.elinabookstore.model.User;
import com.example.elinabookstore.model.UserRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository repository;

	@Test
	public void createNewUser() {
		User user = new User("test", "0cbc6611f5540bd0809a388dc95a615b", "test@test.com", "TEST");
		
		repository.save(user);
		assertThat(user.getId()).isNotNull();
	}
	
	@Test
	public void deleteUser() {
		List<User> users = repository.findByUsername("user");
		User user = users.get(0);
		
		repository.delete(user);
		List<User> newUsers = repository.findByUsername("user");
		assertThat(newUsers).hasSize(0);
	}
	
	@Test
	public void findUserByUsernameShouldReturnUser() {
		List<User> users = repository.findByUsername("admin");
		assertThat(users).hasSize(1);
	}
}
