package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.core.AbstractApplication;
import org.kie.kogito.research.application.core.RelativeUriId;
import org.kie.kogito.research.application.core.SimpleUnitContainer;
import org.kie.kogito.research.processes.api.Process;

public class TestApp extends AbstractApplication {

    public SimpleUnitContainer<Process> processes;

    {

        processes = new SimpleUnitContainer<>(this, RelativeUriId.of("processes"));
        register(Process.class, processes);
    }
}
