package org.kie.kogito.research.processes.api;

import org.kie.kogito.research.application.api.MessageBus;
import org.kie.kogito.research.application.api.UnitInstance;

public interface ProcessInstance extends UnitInstance {
    @Override ProcessInstanceId id();
    @Override Process unit();
    @Override MessageBus<ProcessEvent> messageBus(); // send(Event)
    @Override void run();
}
