package org.kie.kogito.research.integration.tests.server;

import org.kie.kogito.research.processes.api.ProcessInstanceMessageBus;
import org.kie.kogito.research.processes.api.ids.ProcessId;
import org.kie.kogito.research.processes.api.ids.ProcessInstanceId;
import org.kie.kogito.research.processes.core.impl.AbstractProcessInstanceImpl;
import org.kie.kogito.research.processes.core.impl.SimpleProcessInstanceId;

import java.util.UUID;

public class ProcessInstanceImpl extends AbstractProcessInstanceImpl {

    private final ProcessInstanceId processInstanceId = SimpleProcessInstanceId.fromString(UUID.randomUUID().toString());

    public ProcessInstanceImpl(ProcessInstanceMessageBus messageBus, ProcessId processId) {
        super(messageBus, processId);
    }

    @Override
    public ProcessInstanceId getInstanceId() {
        return processInstanceId;
    }



}
