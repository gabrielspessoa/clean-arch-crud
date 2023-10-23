package com.cleanarch.core.usecases;

import com.cleanarch.core.entities.Todo;
import com.cleanarch.core.gateways.TodoGateway;

public class ListAllTodosUseCase {
    private TodoGateway todoGateway;

    public ListAllTodosUseCase(TodoGateway todoGateway) {
        this.todoGateway = todoGateway;
    }

    public Iterable<Todo> listAll() {
        return todoGateway.listAll();
    }
}
