package org.kie.kogito.research.processes.api.v2;

import org.kie.kogito.research.application.api.AddressableContainerFactory;
import org.kie.kogito.research.application.api.v2.Type;
import org.kie.kogito.research.processes.api.Task;
import org.kie.kogito.research.processes.api.TaskInstance;

public interface Tasks {
    Type<Task> type = new Type<>("tasks");
    Type<AddressableContainerFactory<TaskInstance>> instances = new Type<>("instances");
}
