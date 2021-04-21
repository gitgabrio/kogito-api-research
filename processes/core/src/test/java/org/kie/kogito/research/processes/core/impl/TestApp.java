package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.core.AbstractApplication;
import org.kie.kogito.research.processes.api.ProcessContainer;

public class TestApp extends AbstractApplication {

    {
        register(ProcessContainer.class, new ProcessContainerImpl(id()));
    }
}
