package com.cga.hexatodo.application.usecase;

import com.cga.hexatodo.domain.model.AdditionalTaskInfo;
import com.cga.hexatodo.domain.port.in.GetAdditionalTaskInfoUseCase;
import com.cga.hexatodo.domain.port.out.ExternalServicePort;

public class GetAdditionalTaskInfoUseCaseImpl implements GetAdditionalTaskInfoUseCase {

    private final ExternalServicePort externalServicePort;

    public GetAdditionalTaskInfoUseCaseImpl(ExternalServicePort externalServicePort) {
        this.externalServicePort = externalServicePort;
    }

    @Override
    public AdditionalTaskInfo getAddittionalTaskInfo(Long id) {
        return externalServicePort.getAdditionalTaskInfo(id);
    }
}
