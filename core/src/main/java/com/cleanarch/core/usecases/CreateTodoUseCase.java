package com.cleanarch.core.usecases;

import com.cleanarch.core.entities.Todo;
import com.cleanarch.core.gateways.TodoGateway;

public class CreateTodoUseCase {
    private TodoGateway todoGateway;

    public CreateTodoUseCase(TodoGateway todoGateway) {
        this.todoGateway = todoGateway;
    }

    public Todo create(Todo todo) {
        return todoGateway.create(todo);
    }
}
