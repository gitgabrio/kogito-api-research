package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.AddressableContainer;
import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.api.RelativeId;
import org.kie.kogito.research.application.core.AbstractAddressable;
import org.kie.kogito.research.application.core.AbstractAddressableContainer;
import org.kie.kogito.research.application.core.RelativeUriId;
import org.kie.kogito.research.processes.api.Process;
import org.kie.kogito.research.processes.api.ProcessContainer;
import org.kie.kogito.research.processes.api.ProcessInstance;
import org.kie.kogito.research.processes.api.ProcessInstanceContainer;
import org.kie.kogito.research.processes.api.tasks.TaskInstance;
import org.kie.kogito.research.processes.core.tasks.impl.TaskInstanceContainer;

// /processes
class ProcessContainerImpl extends AbstractAddressableContainer<Process> implements ProcessContainer {
    public ProcessContainerImpl(Id id) { super(id); }
    @Override public Process get(RelativeId id) {
        return new ProcessImpl(id().append(id));
    }
}

// /processes/$process_id
class ProcessImpl extends AbstractAddressable implements Process {
    public ProcessImpl(Id id) { super(id); }
    @Override public ProcessInstanceContainer instances() {
        return new ProcessInstanceContainerImpl(id().append(RelativeUriId.of("instances")));
    }
}

// /processes/$process_id/instances
class ProcessInstanceContainerImpl extends AbstractAddressableContainer<ProcessInstance> implements ProcessInstanceContainer {
    public ProcessInstanceContainerImpl(Id id) { super(id); }
    @Override public ProcessInstanceImpl get(RelativeId id) {
        return new ProcessInstanceImpl(id().append(id));
    }
}

// /processes/$process_id/instances/$process_instance_id
class ProcessInstanceImpl extends AbstractAddressable implements ProcessInstance {
    public ProcessInstanceImpl(Id processInstanceId) { super(processInstanceId); }
    public AddressableContainer<TaskInstance> tasks() {
        return new TaskInstanceContainer(id().append(RelativeUriId.of("tasks")));
    }
}

