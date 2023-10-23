package com.cleanarch.core.gateways;

import com.cleanarch.core.entities.Todo;

public interface TodoGateway {
    Iterable<Todo> listAll ();
    Todo create(Todo todo);
    Todo deleteById (Integer id);
}
