package org.kie.kogito.research.processes.api;

import org.kie.kogito.research.application.api.UnitInstanceContainer;
import org.kie.kogito.research.application.api.UnitInstanceId;

public interface ProcessInstanceContainer extends UnitInstanceContainer<ProcessInstance> {
    @Override ProcessInstance get(UnitInstanceId instanceId);
    @Override ProcessInstance create();
}
