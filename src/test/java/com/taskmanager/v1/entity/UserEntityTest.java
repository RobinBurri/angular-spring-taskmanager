package com.taskmanager.v1.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(classes = User.class)
@TestPropertySource("/application-test.properties")
public class UserEntityTest {
    

    @Test
    @Description("Test both User constuructors")
    public void testUserConstuctors() {
        User user = new User();
        assertEquals(0, user.getId());
        assertEquals(null, user.getFirstName());
        assertEquals(null, user.getLastName());
        assertEquals(null, user.getEmail());
        assertEquals(null, user.getUserName());
        assertEquals(null, user.getPassword());
        assertEquals(null, user.getTasks());

        user = new User("firstName", "lastName", "email", "userName", "password");
        assertEquals(0, user.getId());
        assertEquals("firstName", user.getFirstName());
        assertEquals("lastName", user.getLastName());
        assertEquals("email", user.getEmail());
        assertEquals("userName", user.getUserName());
        assertEquals("password", user.getPassword());
        assertEquals(null, user.getTasks());
    }

    
}
