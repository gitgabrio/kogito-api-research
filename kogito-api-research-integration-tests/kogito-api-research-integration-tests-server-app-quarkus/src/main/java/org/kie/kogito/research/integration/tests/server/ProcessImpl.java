package org.kie.kogito.research.integration.tests.server;

import org.kie.kogito.research.processes.api.ProcessId;
import org.kie.kogito.research.processes.api.ProcessInstanceId;
import org.kie.kogito.research.processes.core.impl.AbstractProcessImpl;
import org.kie.kogito.research.processes.core.impl.SimpleProcessId;
import org.kie.kogito.research.processes.core.impl.SimpleProcessInstanceId;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class ProcessImpl extends AbstractProcessImpl {


    private final ProcessId processId = SimpleProcessId.fromString("ProcessImplId"); // <- "ProcessImplId" to be replaced by code-generation
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
