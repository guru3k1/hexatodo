package com.cga.hexatodo.domain.port.in;

import com.cga.hexatodo.domain.model.Task;

public interface CreateTaskUseCase {

    Task createTask(Task task);
}
