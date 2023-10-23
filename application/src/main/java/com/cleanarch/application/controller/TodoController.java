package com.cleanarch.application.controller;

import com.cleanarch.core.entities.Todo;
import com.cleanarch.core.usecases.CreateTodoUseCase;
import com.cleanarch.core.usecases.DeleteTodoUseCase;
import com.cleanarch.core.usecases.ListAllTodosUseCase;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/todo")
public class TodoController {
    CreateTodoUseCase createTodoUseCase;
    ListAllTodosUseCase listAllTodosUseCase;
    DeleteTodoUseCase deleteTodoUseCase;
    TodoDTOMapper todoDTOMapper;

    public TodoController(CreateTodoUseCase createTodoUseCase, ListAllTodosUseCase listAllTodosUseCase, DeleteTodoUseCase deleteTodoUseCase, TodoDTOMapper todoDTOMapper) {
        this.createTodoUseCase = createTodoUseCase;
        this.listAllTodosUseCase = listAllTodosUseCase;
        this.deleteTodoUseCase = deleteTodoUseCase;
        this.todoDTOMapper = todoDTOMapper;
    }

    @GetMapping("/all")
    public Iterable<Todo> show() {
        return listAllTodosUseCase.listAll();
    }

    @PostMapping("/create")
    public @ResponseBody CreateTodoResponse create(@RequestBody CreateTodoRequest request) {
        Todo todoDomainObj = todoDTOMapper.toDomainObj(request);
        Todo todo = createTodoUseCase.create(todoDomainObj);
        return todoDTOMapper.toResponse(todo);
    }

//    @PatchMapping
//    public @ResponseBody String update(@RequestBody Todo todo) {
//        Todo updatedTodo = rep.findById(todo.getId()).orElseThrow();
//        updatedTodo.setDone(todo.getDone());
//        rep.save(updatedTodo);
//        System.out.println(String.format("Lembrete %s atualizado para %b", updatedTodo.getAction(), updatedTodo.getDone()));
//
//        return "Atualizado.";
//    }

    @DeleteMapping("/{id}")
    public @ResponseBody Todo delete(@PathVariable("id") Integer id) {
        Todo deletedTodo = deleteTodoUseCase.deleteById(id);
        return deletedTodo;
    }
}
