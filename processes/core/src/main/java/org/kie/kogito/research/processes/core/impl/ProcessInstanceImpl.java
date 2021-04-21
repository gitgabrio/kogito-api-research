package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.AddressableContainer;
import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.core.AbstractAddressable;
import org.kie.kogito.research.application.core.AbstractAddressableContainer;
import org.kie.kogito.research.application.core.RelativeUriId;
import org.kie.kogito.research.processes.api.ProcessInstance;
import org.kie.kogito.research.processes.api.TaskInstance;

public class ProcessInstanceImpl extends AbstractAddressable implements ProcessInstance {

    public ProcessInstanceImpl(Id id) {
        super(id);
    }
    @Override
    public AddressableContainer<TaskInstance> tasks() {
        return new TaskInstanceContainer(id().append(RelativeUriId.of("tasks")));
    }

}
