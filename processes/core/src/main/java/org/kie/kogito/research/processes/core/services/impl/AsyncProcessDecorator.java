package org.kie.kogito.research.processes.core.services.impl;

import org.kie.kogito.research.application.api.Context;
import org.kie.kogito.research.processes.api.Process;
import org.kie.kogito.research.processes.api.ProcessInstance;

import java.util.concurrent.CompletableFuture;

public class AsyncProcessDecorator {
    private final ProcessServiceImpl svc;
    private final Process process;

    public AsyncProcessDecorator(ProcessServiceImpl svc, Process process) {
        this.svc = svc;
        this.process = process;
    }

    public CompletableFuture<ProcessInstance> start(Context ctx) {
        return CompletableFuture.completedFuture(svc.start(process, ctx));
    }


}