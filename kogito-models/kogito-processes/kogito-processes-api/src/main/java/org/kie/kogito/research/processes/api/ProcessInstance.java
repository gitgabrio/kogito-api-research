package org.kie.kogito.research.processes.api;

import org.kie.kogito.research.application.api.MessageBus;
import org.kie.kogito.research.application.api.ModelInstance;
import org.kie.kogito.research.processes.api.ids.ProcessId;
import org.kie.kogito.research.processes.api.ids.ProcessInstanceId;

public interface ProcessInstance extends ModelInstance<ProcessId,
        ProcessInstanceId, ProcessInstanceMessage, ProcessInstanceEvent> {

    @Override ProcessInstanceId instanceId();
    @Override
    ProcessInstanceMessageBus messageBus(); // send(Event)
    @Override void run();
}
