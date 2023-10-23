package com.cleanarch.application.persistence;

import com.cleanarch.application.repository.TodoEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<TodoEntity, Integer> {

}
