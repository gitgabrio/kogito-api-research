package org.kie.kogito.research.processes.core.service.impl;

import org.kie.kogito.research.application.api.Context;
import org.kie.kogito.research.application.api.Event;
import org.kie.kogito.research.processes.api.ProcessInstance;

public class ProcessInstanceDecorator {
    private final ProcessServiceImpl processService;
    private final ProcessInstance id;

    public ProcessInstanceDecorator(ProcessServiceImpl processService, ProcessInstance id) {
        this.processService = processService;
        this.id = id;
    }

    public void start(Context ctx) {
        processService.start(id, ctx);
    }

    public void abort() {
        processService.abort(id);
    }


    public <T extends Context> T context(Class<T> ctx) {
        return processService.context(id, ctx);
    }

    public void update(Context ctx) {
        processService.update(id, ctx);
    }

    public void send(Event event) {
        processService.send(id, event);
    }
}
