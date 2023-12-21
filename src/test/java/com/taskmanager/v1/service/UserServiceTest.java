package com.taskmanager.v1.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;

import com.taskmanager.v1.exception.UserNotFoundException;
import com.taskmanager.v1.repository.UserDao;

@TestPropertySource("/application-test.properties")
@SpringBootTest(classes = UserService.class)
public class UserServiceTest {

    @MockBean
    private UserDao userDao;

    @Autowired
    private UserService userService;

    @Test
    public void throwAnUserNotFoundException() {
        when(userDao.findById(0)).thenThrow(new UserNotFoundException("User not found with id: " + 0));
        assertThrows(UserNotFoundException.class, () -> userService.getUser(0), "Should throw an exception");
    }

}
