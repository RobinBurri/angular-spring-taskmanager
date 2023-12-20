package com.taskmanager.v1.repository;

import org.springframework.data.repository.CrudRepository;

import com.taskmanager.v1.entity.Task;

public interface TaskDao extends CrudRepository<Task, Integer>{
    
}
