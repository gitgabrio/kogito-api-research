package org.kie.kogito.research.processes.core.services.impl;

import org.kie.kogito.research.application.api.Context;
import org.kie.kogito.research.application.api.Event;
import org.kie.kogito.research.application.core.RelativeUriId;
import org.kie.kogito.research.processes.api.Process;
import org.kie.kogito.research.processes.api.ProcessInstance;

import java.util.function.Function;

// mock impl
public class ProcessServiceImpl {

    ProcessInstance start(Process id, Context ctx) {
        System.out.printf("START %s\n", id.id());
        return id.instances().get(RelativeUriId.random());
    }

    ProcessInstance start(ProcessInstance id, Context ctx) {
        System.out.printf("START %s\n", id.id());
        return id;
    }


    void abort(ProcessInstance id) {
        System.out.printf("ABORT %s\n", id.id());
    }


    public void update(ProcessInstance id, Context ctx) {
        System.out.printf("UPDATE %s\n", id.id());
    }

    public void send(ProcessInstance id, Event event) {
        System.out.printf("SEND %s\n", id.id());
    }

    public <T extends Context> T context(ProcessInstance id, Class<T> ctx) {
        return null;
    }
}
