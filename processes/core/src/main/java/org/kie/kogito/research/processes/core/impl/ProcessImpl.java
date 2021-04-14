package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.Context;
import org.kie.kogito.research.application.api.UnitId;
import org.kie.kogito.research.application.api.impl.AbstractUnit;
import org.kie.kogito.research.application.core.SimpleUnitInstanceId;
import org.kie.kogito.research.processes.api.Process;
import org.kie.kogito.research.processes.api.ProcessContainer;
import org.kie.kogito.research.processes.api.ProcessInstance;

public class ProcessImpl extends AbstractUnit implements Process {

    public ProcessImpl(ProcessContainer container, UnitId id) {
        super(container, id);
    }

    public ProcessImpl(ProcessContainerImpl processContainer, UnitId id) {
        super(processContainer, id);
    }

    @Override
    public ProcessInstance createInstance(Context ctx) {
        var id = SimpleUnitInstanceId.create();
        return (ProcessInstance) register(new ProcessInstanceImpl(id, this, ctx));
    }
}
