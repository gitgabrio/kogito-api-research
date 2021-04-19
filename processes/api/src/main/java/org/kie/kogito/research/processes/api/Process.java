package org.kie.kogito.research.processes.api;

import org.kie.kogito.research.application.api.Unit;
import org.kie.kogito.research.application.api.AddressableContainerFactory;

public interface Process extends Unit<Process> {
    @Override
    AddressableContainerFactory<ProcessInstance> instances();
}
