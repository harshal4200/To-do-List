package com.example.todolist.controller;

import com.example.todolist.service.TodoService;
import com.example.todolist.entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;

    // Get all tasks
    @GetMapping
    public List<Todo> getAllTasks() {
        return todoService.getAllTasks();
    }

    // Add a new task
    @PostMapping
    public Todo addTask(@RequestBody Todo todo) {
        return todoService.addTask(todo);
    }

    // Update a task
    @PutMapping("/{id}")
    public Todo updateTask(@PathVariable Long id, @RequestBody Todo updatedTodo) {
        return todoService.updateTask(id, updatedTodo);
    }

    // Delete a task
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        todoService.deleteTask(id);
    }
}
