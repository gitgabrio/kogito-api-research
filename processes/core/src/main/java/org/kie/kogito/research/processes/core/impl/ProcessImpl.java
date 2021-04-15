package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.UnitContainer;
import org.kie.kogito.research.application.api.UnitId;
import org.kie.kogito.research.application.api.UnitInstanceContainer;
import org.kie.kogito.research.application.core.AbstractUnit;
import org.kie.kogito.research.processes.api.Process;
import org.kie.kogito.research.processes.api.ProcessInstance;

public class ProcessImpl extends AbstractUnit implements Process {

    UnitInstanceContainer<ProcessInstance> container = new ProcessInstanceContainer(this.id());

    public ProcessImpl(UnitContainer<Process> container, UnitId id) {
        super(container, id);
    }

    public ProcessImpl(ProcessContainerImpl processContainer, UnitId id) {
        super(processContainer, id);
    }

    @Override
    public UnitInstanceContainer<ProcessInstance> instances() {
        return container;
    }
}
