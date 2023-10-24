package com.cga.hexatodo.domain.port.in;

import com.cga.hexatodo.domain.model.Task;

import java.util.Optional;

public interface UpdateTaskUserCase {

    Optional<Task> updateTask(Long id, Task updateTask);
}
