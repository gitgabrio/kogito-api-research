package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.UnitId;
import org.kie.kogito.research.application.api.UnitInstanceContainer;
import org.kie.kogito.research.application.core.AbstractUnit;
import org.kie.kogito.research.processes.api.Process;
import org.kie.kogito.research.processes.api.ProcessInstance;

public class ProcessImpl extends AbstractUnit<Process> implements Process {

    UnitInstanceContainer<Process, ProcessInstance> container = new ProcessInstanceContainer(this.id());

    public ProcessImpl(ProcessContainerImpl processContainer, UnitId id) {
        super(processContainer, id);
    }

    @Override
    public UnitInstanceContainer<Process, ProcessInstance> instances() {
        return container;
    }
}
