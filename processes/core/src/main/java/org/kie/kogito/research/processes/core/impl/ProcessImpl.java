package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.UnitId;
import org.kie.kogito.research.application.api.UnitInstanceContainer;
import org.kie.kogito.research.application.core.AbstractUnit;
import org.kie.kogito.research.processes.api.Process;
import org.kie.kogito.research.processes.api.ProcessInstance;

public class ProcessImpl extends AbstractUnit<Process> implements Process {

    public ProcessImpl(UnitId id) {
        super(new ProcessInstanceContainer(id), id);
    }

    @Override
    public UnitInstanceContainer<Process, ProcessInstance> instances() {
        return (UnitInstanceContainer<Process, ProcessInstance>) super.instances();
    }
}
