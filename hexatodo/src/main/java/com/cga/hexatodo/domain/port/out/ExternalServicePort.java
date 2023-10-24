package com.cga.hexatodo.domain.port.out;

import com.cga.hexatodo.domain.model.AdditionalTaskInfo;

public interface ExternalServicePort {

    AdditionalTaskInfo getAdditionalTaskInfo(Long taskId);
}
