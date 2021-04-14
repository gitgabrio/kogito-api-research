package org.kie.kogito.research.processes.api;

import org.kie.kogito.research.application.api.UnitInstanceContainer;
import org.kie.kogito.research.application.api.UnitInstanceId;

public interface TaskInstanceContainer extends UnitInstanceContainer {
    @Override TaskInstance get(UnitInstanceId instanceId);
}
