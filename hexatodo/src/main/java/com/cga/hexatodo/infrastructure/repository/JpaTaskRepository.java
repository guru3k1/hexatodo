package com.cga.hexatodo.infrastructure.repository;

import com.cga.hexatodo.infrastructure.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaTaskRepository extends JpaRepository<TaskEntity,Long> {
}
