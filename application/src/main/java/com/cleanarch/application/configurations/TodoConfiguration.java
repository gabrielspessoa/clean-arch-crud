package com.cleanarch.application.configurations;

import com.cleanarch.application.controller.TodoDTOMapper;
import com.cleanarch.application.gateways.TodoEntityMapper;
import com.cleanarch.application.gateways.TodoRepositoryGateway;
import com.cleanarch.application.persistence.TodoRepository;
import com.cleanarch.core.gateways.TodoGateway;
import com.cleanarch.core.usecases.CreateTodoUseCase;
import com.cleanarch.core.usecases.ListAllTodosUseCase;
import com.cleanarch.core.usecases.DeleteTodoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TodoConfiguration {
    @Bean
    CreateTodoUseCase createTodoUseCase(TodoGateway todoGateway) {
        return new CreateTodoUseCase(todoGateway);
    }

    @Bean
    ListAllTodosUseCase listAllTodosUseCase(TodoGateway todoGateway) {
        return new ListAllTodosUseCase(todoGateway);
    }

    @Bean
    DeleteTodoUseCase deleteTodoUseCase(TodoGateway todoGateway) {
        return new DeleteTodoUseCase(todoGateway);
    }

    @Bean
    TodoGateway todoGateway(TodoRepository todoRepository, TodoEntityMapper todoEntityMapper) {
        return new TodoRepositoryGateway(todoRepository, todoEntityMapper);
    }

    @Bean
    TodoEntityMapper todoEntityMapper() {
        return new TodoEntityMapper();
    }

    @Bean
    TodoDTOMapper todoDTOMapper() {
        return new TodoDTOMapper();
    }

}
