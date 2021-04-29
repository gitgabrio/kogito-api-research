package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.core.AbstractAddressable;
import org.kie.kogito.research.application.core.RelativeUriId;
import org.kie.kogito.research.processes.api.Process;
import org.kie.kogito.research.processes.api.ProcessInstanceContainer;

public class ProcessImpl extends AbstractAddressable implements Process {

    public ProcessImpl(Id id) {
        super(id);
    }

    @Override
    public ProcessInstanceContainer instances() {
        return new ProcessInstanceContainerImpl(id().append(RelativeUriId.of("instances")));
    }
}
