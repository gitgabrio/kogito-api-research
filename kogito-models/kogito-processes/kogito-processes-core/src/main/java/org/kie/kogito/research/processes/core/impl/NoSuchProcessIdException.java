package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.processes.api.ids.ProcessId;

public class NoSuchProcessIdException extends RuntimeException {
    private final ProcessId processId;

    public NoSuchProcessIdException(ProcessId processId) {
        super("No such process id " + processId);
        this.processId = processId;
    }
}
