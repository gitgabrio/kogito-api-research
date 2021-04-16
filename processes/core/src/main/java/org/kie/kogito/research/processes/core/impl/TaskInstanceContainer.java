package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.Context;
import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.api.RelativeId;
import org.kie.kogito.research.application.core.AbstractUnitInstanceContainer;
import org.kie.kogito.research.processes.api.TaskInstance;

public class TaskInstanceContainer extends AbstractUnitInstanceContainer<TaskInstance> {

    public TaskInstanceContainer(Id parentId) {
        super(parentId, "tasks");
    }

    @Override
    public TaskInstance get(RelativeId unitId) {
        // recreate just for mock
        return create0(null);
    }

    @Override
    public TaskInstance create0(Context ctx) {
        return new HumanTaskInstance(this.id());
    }

}