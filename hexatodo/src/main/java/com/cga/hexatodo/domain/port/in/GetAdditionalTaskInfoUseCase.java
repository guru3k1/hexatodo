package com.cga.hexatodo.domain.port.in;

import com.cga.hexatodo.domain.model.AdditionalTaskInfo;

public interface GetAdditionalTaskInfoUseCase {

    AdditionalTaskInfo getAddittionalTaskInfo(Long id);
}
