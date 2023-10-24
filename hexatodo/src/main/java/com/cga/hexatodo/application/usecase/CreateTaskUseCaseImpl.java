package com.cga.hexatodo.application.usecase;

import com.cga.hexatodo.domain.model.Task;
import com.cga.hexatodo.domain.port.in.CreateTaskUseCase;
import com.cga.hexatodo.domain.port.out.TaskRepositoryPort;

public class CreateTaskUseCaseImpl implements CreateTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    public CreateTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Task createTask(Task task) {
        return taskRepositoryPort.save(task);
    }
}
