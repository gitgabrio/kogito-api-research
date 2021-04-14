package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.Context;
import org.kie.kogito.research.application.api.UnitInstanceId;
import org.kie.kogito.research.application.api.impl.AbstractUnitInstance;
import org.kie.kogito.research.processes.api.Process;
import org.kie.kogito.research.processes.api.ProcessInstance;

public class ProcessInstanceImpl extends AbstractUnitInstance implements ProcessInstance {

    public ProcessInstanceImpl(UnitInstanceId id, Process unit, Context context) {
        super(id, unit, context);
    }

    @Override
    public Process unit() {
        return (Process) super.unit();
    }

}
