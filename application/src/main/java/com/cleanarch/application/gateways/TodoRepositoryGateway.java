package com.cleanarch.application.gateways;

import com.cleanarch.application.persistence.TodoRepository;
import com.cleanarch.application.repository.TodoEntity;
import com.cleanarch.core.entities.Todo;
import com.cleanarch.core.gateways.TodoGateway;

import java.util.ArrayList;
import java.util.List;

public class TodoRepositoryGateway implements TodoGateway {
    private final TodoRepository todoRepository;
    private final TodoEntityMapper todoEntityMapper;

    public TodoRepositoryGateway(TodoRepository todoRepository, TodoEntityMapper todoEntityMapper) {
        this.todoRepository = todoRepository;
        this.todoEntityMapper = todoEntityMapper;
    }

    @Override
    public Todo create(Todo todoDomainObj) {
        if (todoDomainObj.getDone() == null) {
            todoDomainObj.setDone(false);
        }
        TodoEntity todoEntity = todoEntityMapper.toEntity(todoDomainObj);
        TodoEntity savedObj = todoRepository.save(todoEntity);
        return todoEntityMapper.toDomainObj(savedObj);
    }

    @Override
    public Iterable<Todo> listAll() {
        Iterable<TodoEntity> todoListEntity = todoRepository.findAll();
        List<Todo> todoListDomainObj = new ArrayList<>();
        todoListEntity.forEach((todoEntity) -> {
            todoListDomainObj.add(todoEntityMapper.toDomainObj(todoEntity));
        });
        return todoListDomainObj;
    }

    @Override
    public Todo deleteById(Integer id) {
        TodoEntity deletedTodoEntity = todoRepository.findById(id).orElseThrow();
        todoRepository.deleteById(deletedTodoEntity.getId());
        return todoEntityMapper.toDomainObj(deletedTodoEntity);
    }
}
