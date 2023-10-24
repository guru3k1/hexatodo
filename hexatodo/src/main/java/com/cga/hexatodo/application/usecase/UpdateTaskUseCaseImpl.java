package com.cga.hexatodo.application.usecase;

import com.cga.hexatodo.domain.model.Task;
import com.cga.hexatodo.domain.port.in.UpdateTaskUseCase;
import com.cga.hexatodo.domain.port.out.TaskRepositoryPort;

import java.util.Optional;

public class UpdateTaskUseCaseImpl implements UpdateTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    public UpdateTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Optional<Task> updateTask(Long id, Task updateTask) {
        return taskRepositoryPort.update(updateTask);
    }
}
