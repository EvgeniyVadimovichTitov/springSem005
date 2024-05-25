package com.example.seminar005;

import com.example.seminar005.models.Task;
import com.example.seminar005.models.TaskStatus;
import com.example.seminar005.repositories.IRepository;
import com.example.seminar005.servises.Servise;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UpdateStatusTaskServiceModelTest {
    @Mock
    private IRepository repository;

    @InjectMocks
    private Servise servise;

    @Test
    public void correctUpdateStatusTaskById(){
       //блок предусловия
        Task task = new Task();
        task.setId(1L);
        task.setStatus(TaskStatus.IN_PROGRESS);
        task.setName("Test");

        given(repository.findById(task.getId())).willReturn(Optional.of(task));
        //блок действия

        servise.updateTaskStatus(1L);

        //блок проверки

        verify(repository).save(task);
    }
}
