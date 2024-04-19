package com.example.seminar005.repositories;

import com.example.seminar005.models.Task;
import com.example.seminar005.models.TaskStatus;
import jakarta.persistence.QueryHint;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IRepository extends JpaRepository<Task, Long> {
    //@Query("SELECT * FROM tasks WHERE status = :status")
    List<Task> getTasksByStatus(TaskStatus status);

}
