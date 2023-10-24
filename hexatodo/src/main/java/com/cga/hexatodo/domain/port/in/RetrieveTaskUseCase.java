package com.cga.hexatodo.domain.port.in;

import com.cga.hexatodo.domain.model.Task;

import java.util.List;
import java.util.Optional;

public interface RetrieveTaskUseCase {

    Optional<Task> getTask(Long id);

    List<Task> getAllTasks();
}
