package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.Context;
import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.core.AbstractUnitInstanceContainer;
import org.kie.kogito.research.application.core.UriId;
import org.kie.kogito.research.processes.api.ProcessInstance;

import java.util.UUID;

public class ProcessInstanceContainer extends AbstractUnitInstanceContainer<ProcessInstance> {

    public ProcessInstanceContainer(Id parentId) {
        super(parentId, "instances");
    }

    @Override
    public ProcessInstance create0(Context ctx) {
        // ... use processImpl here ...
        return new ProcessInstanceImpl(new UriId(this.id(), UUID.randomUUID().toString()));
    }
}
