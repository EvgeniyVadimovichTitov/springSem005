package com.example.seminar005.servises;

import com.example.seminar005.models.Task;
import com.example.seminar005.models.TaskStatus;
import com.example.seminar005.repositories.IRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Servise implements IServise{

    private final IRepository repository;

    //create task in db
    @Override
    public Task addTask(Task task) {
        return repository.save(task);
    }
    //select all tasks from db
    @Override
    public Iterable<Task> getAllTasks() {
        return repository.findAll();
    }

    //get tasks from db by status
    @Override
    public List<Task> getTasksByStatus(TaskStatus status) {
        return repository.getTasksByStatus(status);
    }

    @Override
    public Task updateTaskStatus(Long id) {
            Task taskDb = repository.findById(id).orElseThrow();
                switch (taskDb.getStatus()){
                    case NOT_STARTED -> taskDb.setStatus(TaskStatus.IN_PROGRESS);
                    case IN_PROGRESS -> taskDb.setStatus(TaskStatus.COMPLETED);
                    default -> {
                        return taskDb;
                    }
                }

            return repository.save(taskDb);
    }

    @Override
    public void deleteTask(Long id) {
        repository.deleteById(id);
    }
}
