package com.taskmanager.v1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.taskmanager.v1.entity.User;
import com.taskmanager.v1.repository.UserDao;

@SpringBootApplication
public class V1Application {

	public static void main(String[] args) {
		SpringApplication.run(V1Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserDao userDao) {
		return runner -> {
			createOneUser(userDao);
		};
	}

	private void createOneUser(UserDao userDao) {
		User user = new User("Robin", "Burri", "robin@example.com", "userOne", "passwordOne");
		userDao.save(user);
	}
}
