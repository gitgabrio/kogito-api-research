package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.core.AbstractAddressableContainer;
import org.kie.kogito.research.processes.api.ProcessInstance;

public class ProcessInstanceContainer extends AbstractAddressableContainer<ProcessInstance> {

    public ProcessInstanceContainer(Id id) {
        super(id);
    }

    @Override
    public ProcessInstance create(Id id) {
        // ... use processImpl here ...
        return new ProcessInstanceImpl(id);
    }
}
