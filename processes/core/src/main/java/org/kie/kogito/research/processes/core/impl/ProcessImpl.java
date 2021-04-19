package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.core.AbstractUnit;
import org.kie.kogito.research.processes.api.Process;
import org.kie.kogito.research.processes.api.ProcessInstance;

public class ProcessImpl extends AbstractUnit<Process, ProcessInstance> implements Process {

    public ProcessImpl(Id id) {
        super(new ProcessInstanceContainer(id), id);
    }

}
