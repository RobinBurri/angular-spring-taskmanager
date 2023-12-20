package com.taskmanager.v1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskmanager.v1.entity.User;
// import com.taskmanager.v1.repository.TaskDao;
import com.taskmanager.v1.repository.UserDao;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserDao userDao;

    // @Autowired
    // private TaskDao taskDao;

    public void createNewUser(String firstName, String lastName, String email, String userName, String password) {
        User user = new User(firstName, lastName, email, userName, password);
        user.setId(0);

        userDao.save(user);
    }

}
