package com.cga.hexatodo.infrastructure.config;

import com.cga.hexatodo.application.service.TaskService;
import com.cga.hexatodo.application.usecase.CreateTaskUseCaseImpl;
import com.cga.hexatodo.application.usecase.DeleteTaskUseCaseImpl;
import com.cga.hexatodo.application.usecase.GetAdditionalTaskInfoUseCaseImpl;
import com.cga.hexatodo.application.usecase.RetrieveTaskUseCaseImpl;
import com.cga.hexatodo.application.usecase.UpdateTaskUseCaseImpl;
import com.cga.hexatodo.domain.port.in.GetAdditionalTaskInfoUseCase;
import com.cga.hexatodo.domain.port.out.ExternalServicePort;
import com.cga.hexatodo.domain.port.out.TaskRepositoryPort;
import com.cga.hexatodo.infrastructure.adapter.ExternalServiceAdapter;
import com.cga.hexatodo.infrastructure.repository.JpaTaskRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public TaskService taskService(TaskRepositoryPort taskRepositoryPort, GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase){
        return new TaskService(
                new CreateTaskUseCaseImpl(taskRepositoryPort),
                new RetrieveTaskUseCaseImpl(taskRepositoryPort),
                new UpdateTaskUseCaseImpl(taskRepositoryPort),
                new DeleteTaskUseCaseImpl(taskRepositoryPort),
                getAdditionalTaskInfoUseCase);
    }

    @Bean
    public TaskRepositoryPort taskRepositoryPort(JpaTaskRepositoryAdapter jpaTaskRepositoryAdapter){
        return jpaTaskRepositoryAdapter;
    }

    @Bean
    public GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase(ExternalServicePort externalServicePort){
        return new GetAdditionalTaskInfoUseCaseImpl(externalServicePort);
    }

    @Bean
    public ExternalServicePort externalServicePort(){
        return new ExternalServiceAdapter();
    }
}
