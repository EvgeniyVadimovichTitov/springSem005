package com.example.seminar005.controllers;

import com.example.seminar005.models.Task;
import com.example.seminar005.models.TaskStatus;
import com.example.seminar005.servises.IServise;


import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class Controller {
    private final IServise servise;

    @GetMapping
    public Iterable<Task> getAllTasks(){
        return servise.getAllTasks();
    }

    @PostMapping("/create")
    public Task createTask(@RequestBody Task task){
        return servise.addTask(task);
    }

    @GetMapping("/status/{status}")
    public List<Task> getTaskByStatus(@PathVariable TaskStatus status){
        return servise.getTasksByStatus(status);
    }

    @PutMapping("/update/{id}")
    public Task updateTask(@PathVariable Long id){
        return servise.updateTaskStatus(id);
    }
    @DeleteMapping("/del/{id}")
    public void delTask(@PathVariable Long id){
        servise.deleteTask(id);
    }
}
