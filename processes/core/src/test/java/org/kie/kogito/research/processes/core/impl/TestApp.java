package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.core.AbstractApplication;
import org.kie.kogito.research.processes.api.Process;

public class TestApp extends AbstractApplication {
    {
        register(Process.class, new ProcessContainerImpl(this));
    }
}
