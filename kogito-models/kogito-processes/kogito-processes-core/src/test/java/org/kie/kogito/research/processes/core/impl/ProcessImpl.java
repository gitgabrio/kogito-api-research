package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.processes.api.ProcessId;
import org.kie.kogito.research.processes.api.ProcessInstanceId;

import java.util.UUID;

public class ProcessImpl extends AbstractProcessImpl {


    private final ProcessId processId = SimpleProcessId.fromString("my.process"); // <- "ProcessImplId" to be replaced by code-generation
    private final ProcessInstanceId processInstanceId = SimpleProcessInstanceId.fromString(UUID.randomUUID().toString());


    @Override
    public ProcessId getId() {
        return processId;
    }

    @Override
    public ProcessInstanceId getInstanceId() {
        return processInstanceId;
    }

}
