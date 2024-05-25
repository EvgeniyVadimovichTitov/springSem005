package com.example.seminar005;

import com.example.seminar005.models.Task;
import com.example.seminar005.models.TaskStatus;
import com.example.seminar005.repositories.IRepository;
import com.example.seminar005.servises.Servise;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UpdateStatusTaskIntegrationTest {

    @Autowired
    private Servise servise;
    @MockBean
    private IRepository repository;

    @Test
    public void correctUpdateStatusTaskById(){
        //блок предусловия
        Task task = new Task();
        task.setId(1L);
        task.setStatus(TaskStatus.IN_PROGRESS);
        task.setName("Test");

        when(repository.findById(task.getId())).thenReturn(Optional.of(task));
        //блок действия

        servise.updateTaskStatus(1L);

        //блок проверки

        verify(repository).save(task);
    }
}
