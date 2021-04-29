package org.kie.kogito.research.processes.core.tasks.impl;

import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.api.RelativeId;
import org.kie.kogito.research.application.core.AbstractAddressableContainer;
import org.kie.kogito.research.processes.api.tasks.TaskInstance;

public class TaskInstanceContainer extends AbstractAddressableContainer<TaskInstance> {
    public TaskInstanceContainer(Id id) {
        super(id);
    }

    @Override
    public TaskInstance get(RelativeId id) {
        return new HumanTaskInstance(id().append(id));
    }
}
