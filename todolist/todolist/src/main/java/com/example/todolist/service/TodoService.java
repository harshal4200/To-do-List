package com.example.todolist.service;

import com.example.todolist.repository.TodoRepository;
import com.example.todolist.entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    // Get all tasks
    public List<Todo> getAllTasks() {
        return todoRepository.findAll();
    }

    // Add a new task
    public Todo addTask(Todo todo) {
        return todoRepository.save(todo);
    }

    // Update a task
    public Todo updateTask(Long id, Todo updatedTodo) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        todo.setTask(updatedTodo.getTask());
        todo.setCompleted(updatedTodo.isCompleted());
        return todoRepository.save(todo);
    }

    // Delete a task
    public void deleteTask(Long id) {
        todoRepository.deleteById(id);
    }
}
