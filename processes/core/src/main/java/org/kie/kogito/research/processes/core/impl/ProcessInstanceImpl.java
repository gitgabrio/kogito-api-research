package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.Context;
import org.kie.kogito.research.application.api.Event;
import org.kie.kogito.research.application.api.UnitInstanceId;
import org.kie.kogito.research.application.core.AbstractUnitInstance;
import org.kie.kogito.research.processes.api.Process;
import org.kie.kogito.research.processes.api.ProcessInstance;

public class ProcessInstanceImpl extends AbstractUnitInstance<Process> implements ProcessInstance {

    public ProcessInstanceImpl(UnitInstanceId id) {
        super(id);
        register(TaskInstanceContainer.class, new TaskInstanceContainer(id()));
    }

    @Override
    public TaskInstanceContainer tasks() {
        return get(TaskInstanceContainer.class);
    }

    @Override
    public <T extends Context> T variables(Class<T> cls) {
        System.out.println("VARIABLES: " + id());
        return null;
    }

    public void start() {
        System.out.println("START: " + id());
    }

    public void abort() {
        System.out.println("ABORT: " + id());
    }

    public <T extends Context> T update(T context) {
        return null;
    }

    public void complete() {
        System.out.printf("COMPLETE: %s\n", id());
    }

    public void send(Event signalEvent) {
        System.out.printf("SEND: %s -- %s\n", id(), signalEvent);
    }


}
