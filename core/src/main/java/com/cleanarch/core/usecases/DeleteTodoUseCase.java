package com.cleanarch.core.usecases;

import com.cleanarch.core.entities.Todo;
import com.cleanarch.core.gateways.TodoGateway;

public class DeleteTodoUseCase {
    private TodoGateway todoGateway;

    public DeleteTodoUseCase(TodoGateway todoGateway) {
        this.todoGateway = todoGateway;
    }

    public Todo deleteById(Integer id) {
        return todoGateway.deleteById(id);
    }
}
