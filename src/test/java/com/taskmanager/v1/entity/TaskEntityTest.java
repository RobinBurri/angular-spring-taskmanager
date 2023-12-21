package com.taskmanager.v1.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;
import org.springframework.test.context.TestPropertySource;

import com.taskmanager.v1.model.Priority;

@SpringBootTest(classes = Task.class)
@TestPropertySource("/application-test.properties")
public class TaskEntityTest {

    @Test
    @Description("Test both Task constuructors")
    public void testTaskConstuctors() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date newDate = new Date(System.currentTimeMillis());

        Task task = new Task();
        assertEquals(0, task.getId());
        assertEquals(null, task.getTitle());
        assertEquals(null, task.getDescription());
        assertEquals(null, task.getPriority());
        assertEquals(null, task.getStatus());
        assertEquals(null, task.getAuthor());
        assertEquals(dateFormat.format(newDate), task.getCreationDate());

        User user = new User("username", "password", "name", "surname", "email");
        task = new Task("title", "description", Priority.HIGH, user);
        assertEquals(0, task.getId());
        assertEquals("title", task.getTitle());
        assertEquals("description", task.getDescription());
        assertEquals(Priority.HIGH, task.getPriority());
        assertEquals(null, task.getStatus());
        assertEquals(user, task.getAuthor());
        assertEquals(dateFormat.format(newDate), task.getCreationDate());

    }
}
