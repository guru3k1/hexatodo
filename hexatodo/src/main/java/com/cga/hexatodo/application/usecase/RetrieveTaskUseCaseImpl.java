package com.cga.hexatodo.application.usecase;

import com.cga.hexatodo.domain.model.Task;
import com.cga.hexatodo.domain.port.in.RetrieveTaskUseCase;
import com.cga.hexatodo.domain.port.out.TaskRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetrieveTaskUseCaseImpl implements RetrieveTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    public RetrieveTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }


    @Override
    public Optional<Task> getTask(Long id) {
        return taskRepositoryPort.findById(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepositoryPort.findAll();
    }
}
