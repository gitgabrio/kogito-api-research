package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.core.AbstractAddressableContainer;
import org.kie.kogito.research.processes.api.ProcessInstance;
import org.kie.kogito.research.processes.api.ProcessInstanceContainer;

public class ProcessInstanceContainerImpl extends AbstractAddressableContainer<ProcessInstance> implements ProcessInstanceContainer {

    public ProcessInstanceContainerImpl(Id id) {
        super(id);
    }

    @Override
    protected ProcessInstance create(Id id) {
        return new ProcessInstanceImpl(id);
    }
}
