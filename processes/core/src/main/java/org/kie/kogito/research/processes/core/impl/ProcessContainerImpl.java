package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.Application;
import org.kie.kogito.research.application.core.SimpleUnitContainer;
import org.kie.kogito.research.processes.api.Process;

import java.util.Collection;

public class ProcessContainerImpl extends SimpleUnitContainer<Process> {

    public ProcessContainerImpl(Application application) {
        super(application, "processes");
    }

    // only for tests
    protected void register(Collection<? extends Process> processes) {
        for (Process p : processes) {
            super.register(p);
        }
    }

}
