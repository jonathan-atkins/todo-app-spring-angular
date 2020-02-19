package com.baeldung.application.controllers;

import com.baeldung.application.entities.Todo;
import com.baeldung.application.repositories.TodoRepository;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoController {

    private final TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("/listTodos")
    public List<Todo> getUsers() {
        return (List<Todo>) todoRepository.findAll();
    }

    @PostMapping("/addTodo")
    Todo addTodo(@RequestBody Todo todo) {
        todoRepository.save(todo);
        return todo;
    }
    
    @DeleteMapping("/deleteTodo")
    void deleteTodo(@RequestBody Todo todo) {
        todoRepository.delete(todo);
    }
    
    @PostMapping("/deleteTodo")
    void deleteTodo2(@RequestBody Todo todo) {
        todoRepository.delete(todo);
    }
    
    //more git testing
    @PutMapping("/toggleCompleted")
    void toggleCompleted(@RequestBody Todo todo) {
        todoRepository.save(todo);
    }

}
