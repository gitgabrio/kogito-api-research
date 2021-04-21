package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.core.AbstractAddressableContainer;
import org.kie.kogito.research.processes.api.Process;
import org.kie.kogito.research.processes.api.ProcessContainer;

public class ProcessContainerImpl extends AbstractAddressableContainer<Process> implements ProcessContainer {
    public ProcessContainerImpl(Id id) {
        super(id);
    }

    @Override
    protected Process create(Id id) {
        return new ProcessImpl(id);
    }
}
