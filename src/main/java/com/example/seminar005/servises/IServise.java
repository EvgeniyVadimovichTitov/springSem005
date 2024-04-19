package com.example.seminar005.servises;

import com.example.seminar005.models.Task;
import com.example.seminar005.models.TaskStatus;

import java.util.List;
import java.util.Optional;

public interface IServise {
    Task addTask(Task task);
    Iterable<Task> getAllTasks();
    List<Task> getTasksByStatus(TaskStatus status);
    Task updateTaskStatus(Long id);
    void deleteTask(Long id);
}
