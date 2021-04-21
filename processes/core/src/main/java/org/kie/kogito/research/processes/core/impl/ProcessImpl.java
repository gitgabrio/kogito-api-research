package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.AddressableContainer;
import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.core.AbstractAddressable;
import org.kie.kogito.research.application.core.RelativeUriId;
import org.kie.kogito.research.processes.api.Process;
import org.kie.kogito.research.processes.api.ProcessInstance;

public class ProcessImpl extends AbstractAddressable implements Process {

    public ProcessImpl(Id id) {
        super(id);
    }

    @Override
    public AddressableContainer<ProcessInstance> instances() {
        return new ProcessInstanceContainer(id().append(RelativeUriId.of("instances")));
    }
}
