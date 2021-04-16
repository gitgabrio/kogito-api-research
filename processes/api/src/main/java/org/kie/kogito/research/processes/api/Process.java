package org.kie.kogito.research.processes.api;

import org.kie.kogito.research.application.api.Unit;
import org.kie.kogito.research.application.api.UnitInstanceContainer;

public interface Process extends Unit<Process> {
    UnitInstanceContainer<Process, ProcessInstance> instances();
}
