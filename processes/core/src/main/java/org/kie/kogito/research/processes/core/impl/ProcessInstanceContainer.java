package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.Context;
import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.core.AbstractUnitInstanceContainer;
import org.kie.kogito.research.application.core.UriUnitId;
import org.kie.kogito.research.processes.api.ProcessInstance;

import java.util.UUID;

public class ProcessInstanceContainer extends AbstractUnitInstanceContainer<ProcessInstance> {

    public ProcessInstanceContainer(Id parentId) {
        super(parentId, "instances");
    }

    @Override
    public ProcessInstance create(Context ctx) {
        return register(new ProcessInstanceImpl(new UriUnitId(this.id(), UUID.randomUUID().toString()), null, ctx));
    }
}
