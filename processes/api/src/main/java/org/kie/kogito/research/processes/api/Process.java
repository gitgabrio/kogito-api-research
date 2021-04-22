package org.kie.kogito.research.processes.api;

import org.kie.kogito.research.application.api.Addressable;
import org.kie.kogito.research.application.api.Evaluable;

public interface Process extends Addressable, Evaluable<Process> {
    ProcessInstanceContainer instances();
}
