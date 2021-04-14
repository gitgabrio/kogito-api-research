package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.Application;
import org.kie.kogito.research.application.api.UnitId;
import org.kie.kogito.research.application.api.impl.AbstractUnitContainer;
import org.kie.kogito.research.processes.api.Process;
import org.kie.kogito.research.processes.api.ProcessContainer;

import java.util.Collection;

public class ProcessContainerImpl extends AbstractUnitContainer<Process> implements ProcessContainer {

    public ProcessContainerImpl(Application application) {
        super(application);
    }

    protected void register(Collection<? extends Process> processes) {
        for (Process p : processes) {
            super.register(p);
        }
    }

    @Override
    public Process get(UnitId unitId) {
        return super.get(unitId);
    }
}
