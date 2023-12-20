package com.taskmanager.v1.repository;

import org.springframework.data.repository.CrudRepository;

import com.taskmanager.v1.entity.User;

public interface UserDao extends CrudRepository<User, Integer>{
    
}
