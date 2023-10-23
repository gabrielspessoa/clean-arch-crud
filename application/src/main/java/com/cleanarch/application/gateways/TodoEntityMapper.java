package com.cleanarch.application.gateways;

import com.cleanarch.application.repository.TodoEntity;
import com.cleanarch.core.entities.Todo;

public class TodoEntityMapper {
    TodoEntity toEntity(Todo todoDomainObj) {
        return new TodoEntity(todoDomainObj.getAction(), todoDomainObj.getDone());
    };

    Todo toDomainObj(TodoEntity todoEntity) {
        return new Todo(todoEntity.getId(), todoEntity.getAction(), todoEntity.getDone());
    }
}
