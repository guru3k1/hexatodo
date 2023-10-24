package com.cga.hexatodo.application.service;

import com.cga.hexatodo.domain.model.Task;
import com.cga.hexatodo.domain.port.in.CreateTaskUseCase;
import com.cga.hexatodo.domain.port.in.DeleteTaskUseCase;
import com.cga.hexatodo.domain.port.in.GetAdditionalTaskInfoUseCase;
import com.cga.hexatodo.domain.port.in.RetrieveTaskUseCase;
import com.cga.hexatodo.domain.port.in.UpdateTaskUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class TaskServiceTest {

    @Mock
    private CreateTaskUseCase createTaskUseCase;
    @Mock
    private RetrieveTaskUseCase retrieveTaskUseCase;
    @Mock
    private UpdateTaskUseCase updateTaskUseCase;
    @Mock
    private DeleteTaskUseCase deleteTaskUseCase;
    @Mock
    private GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase;

    private TaskService taskService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        taskService = new TaskService(createTaskUseCase,retrieveTaskUseCase,
                updateTaskUseCase,deleteTaskUseCase,getAdditionalTaskInfoUseCase);
    }

    @Test
    void createTask() {
        //GIVEN
        Task taskMock = mock(Task.class);
        doReturn(taskMock).when(createTaskUseCase).createTask(taskMock);
        //WHEN
        Task actual = taskService.createTask(taskMock);
        //THEN
        assertEquals(taskMock,actual);
        verify(createTaskUseCase,times(1)).createTask(taskMock);
    }

    @Test
    void deleteTask() {
        boolean expected = true;
        Long id = 1L;
        doReturn(expected).when(deleteTaskUseCase).deleteTask(id);

        boolean actual = taskService.deleteTask(id);

        assertEquals(expected,actual);
        verify(deleteTaskUseCase,times(1)).deleteTask(id);
    }

    @Test
    void getTask() {
        Long id = 1L;
        Task taskMock = mock(Task.class);
        Optional optionalTask = mock(Optional.class);
        doReturn(optionalTask).when(retrieveTaskUseCase).getTask(id);
        doReturn(taskMock).when(optionalTask).orElse(null);

        Optional<Task> actual = taskService.getTask(id);

        assertEquals(taskMock, actual.orElse(null));
        verify(retrieveTaskUseCase,times(1)).getTask(id);
    }

    @Test
    void getAllTasks() {
    }

    @Test
    void updateTask() {
    }

    @Test
    void getAddittionalTaskInfo() {
    }
}