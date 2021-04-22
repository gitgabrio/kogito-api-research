package org.kie.kogito.research.processes.core.services.impl;

import org.kie.kogito.research.application.api.EvaluationServiceFactory;
import org.kie.kogito.research.processes.api.Process;
import org.kie.kogito.research.processes.api.ProcessInstance;
import org.kie.kogito.research.processes.api.tasks.TaskInstance;

public interface ProcessService {
    EvaluationServiceFactory<Process, ProcessDecorator> local =
            id -> new ProcessDecorator(new ProcessServiceImpl(), id);
    EvaluationServiceFactory<Process, AsyncProcessDecorator> async =
            id -> new AsyncProcessDecorator(new ProcessServiceImpl(), id);
    EvaluationServiceFactory<ProcessInstance, ProcessInstanceDecorator> localInstance =
            id -> new ProcessInstanceDecorator(new ProcessServiceImpl(), id);
    EvaluationServiceFactory<TaskInstance, TaskInstanceDecorator> localTask =
            id -> new TaskInstanceDecorator(new TaskServiceImpl(), id);
}

