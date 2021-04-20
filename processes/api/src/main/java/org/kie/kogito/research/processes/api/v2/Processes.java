package org.kie.kogito.research.processes.api.v2;

import org.kie.kogito.research.application.api.v2.BuildableType;
import org.kie.kogito.research.application.api.v2.Type;
import org.kie.kogito.research.processes.api.Process;
import org.kie.kogito.research.processes.api.ProcessInstance;
import org.kie.kogito.research.processes.api.TaskInstance;

public interface Processes {
    Type<Process> type = new Type<>("processes");
    Type<ProcessInstance> instances = new Type<>("instances");
    BuildableType<TaskInstance> tasks = new BuildableType<>("tasks");
}
