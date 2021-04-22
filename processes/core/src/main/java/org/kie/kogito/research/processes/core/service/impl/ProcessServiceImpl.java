package org.kie.kogito.research.processes.core.service.impl;

import org.kie.kogito.research.application.api.Context;
import org.kie.kogito.research.application.api.Event;
import org.kie.kogito.research.application.core.RelativeUriId;
import org.kie.kogito.research.processes.api.Process;
import org.kie.kogito.research.processes.api.ProcessInstance;

import java.util.function.Function;

// mock impl
public class ProcessServiceImpl {

    ProcessInstance start(Process id, Context ctx) {
        return id.instances().get(RelativeUriId.random());
    }

    ProcessInstance start(ProcessInstance id, Context ctx) {
        return id;
    }


    void abort(ProcessInstance id) {
    }


    public void update(ProcessInstance id, Context ctx) {

    }

    public void send(ProcessInstance id, Event event) {

    }

    public <T extends Context> T context(ProcessInstance id, Class<T> ctx) {
        return null;
    }
}
