package com.cleanarch.application.controller;

import com.cleanarch.core.entities.Todo;

public class TodoDTOMapper {
    CreateTodoResponse toResponse(Todo todoDomainObj) {
        return new CreateTodoResponse(todoDomainObj.getId(), todoDomainObj.getAction(), todoDomainObj.getDone());
    }

    Todo toDomainObj(CreateTodoRequest request) {
        return new Todo(request.getAction(), request.getDone());
    }
}
