package com.cga.hexatodo.application.service;

import com.cga.hexatodo.domain.model.AdditionalTaskInfo;
import com.cga.hexatodo.domain.model.Task;
import com.cga.hexatodo.domain.port.in.CreateTaskUseCase;
import com.cga.hexatodo.domain.port.in.DeleteTaskUseCase;
import com.cga.hexatodo.domain.port.in.GetAdditionalTaskInfoUseCase;
import com.cga.hexatodo.domain.port.in.RetrieveTaskUseCase;
import com.cga.hexatodo.domain.port.in.UpdateTaskUseCase;


import java.util.List;
import java.util.Optional;

public class TaskService implements CreateTaskUseCase, RetrieveTaskUseCase, UpdateTaskUseCase, DeleteTaskUseCase, GetAdditionalTaskInfoUseCase {

    private final CreateTaskUseCase createTaskUseCase;
    private final RetrieveTaskUseCase retrieveTaskUseCase;
    private final UpdateTaskUseCase updateTaskUseCase;
    private final DeleteTaskUseCase deleteTaskUseCase;
    private final GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase;

    public TaskService(CreateTaskUseCase createTaskUseCase, RetrieveTaskUseCase retrieveTaskUseCase, UpdateTaskUseCase updateTaskUseCase, DeleteTaskUseCase deleteTaskUseCase, GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase) {
        this.createTaskUseCase = createTaskUseCase;
        this.retrieveTaskUseCase = retrieveTaskUseCase;
        this.updateTaskUseCase = updateTaskUseCase;
        this.deleteTaskUseCase = deleteTaskUseCase;
        this.getAdditionalTaskInfoUseCase = getAdditionalTaskInfoUseCase;
    }

    @Override
    public Task createTask(Task task) {
        return createTaskUseCase.createTask(task);
    }

    @Override
    public boolean deleteTask(Long id) {
        return deleteTaskUseCase.deleteTask(id);
    }

    @Override
    public Optional<Task> getTask(Long id) {
        return retrieveTaskUseCase.getTask(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return retrieveTaskUseCase.getAllTasks();
    }

    @Override
    public Optional<Task> updateTask(Long id, Task updateTask) {
        return updateTaskUseCase.updateTask(id,updateTask);
    }

    @Override
    public AdditionalTaskInfo getAddittionalTaskInfo(Long id) {
        return getAdditionalTaskInfoUseCase.getAddittionalTaskInfo(id);
    }
}
