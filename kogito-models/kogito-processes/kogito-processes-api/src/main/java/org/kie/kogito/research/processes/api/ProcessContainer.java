package org.kie.kogito.research.processes.api;

import org.kie.kogito.research.application.api.ModelContainer;
import org.kie.kogito.research.processes.api.ids.ProcessId;
import org.kie.kogito.research.processes.api.ids.ProcessInstanceId;

public interface ProcessContainer extends ModelContainer<ProcessId, ProcessMessage,  ProcessEvent, Process> {
}
