package org.kie.kogito.research.processes.api;

import org.kie.kogito.research.application.api.Model;
import org.kie.kogito.research.processes.api.ids.ProcessId;

public interface Process extends Model<ProcessId, ProcessMessage, ProcessEvent> {
    @Override ProcessId id();
//    @Override ProcessInstance createInstance(Context ctx);
}
