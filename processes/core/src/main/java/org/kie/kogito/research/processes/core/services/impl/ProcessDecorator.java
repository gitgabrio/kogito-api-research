package org.kie.kogito.research.processes.core.services.impl;

import org.kie.kogito.research.application.api.Context;
import org.kie.kogito.research.processes.api.Process;
import org.kie.kogito.research.processes.api.ProcessInstance;

public class ProcessDecorator {
    private final ProcessServiceImpl processService;
    Process process;

    public ProcessDecorator(ProcessServiceImpl processService, Process id) {

        this.processService = processService;
        this.process = id;
    }

    public ProcessInstance start(Context ctx) {
        return processService.start(process, ctx);
    }


}
