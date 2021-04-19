package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.*;
import org.kie.kogito.research.application.core.AbstractUnitInstance;
import org.kie.kogito.research.processes.api.Process;
import org.kie.kogito.research.processes.api.ProcessInstance;
import org.kie.kogito.research.processes.api.TaskInstance;

public class ProcessInstanceImpl extends AbstractUnitInstance<Process> implements ProcessInstance {

    public ProcessInstanceImpl(Id id) {
        super(id);
        register(TaskInstance.class, new TaskInstanceContainer(id()));
    }

    @Override
    public AddressableContainerFactory<TaskInstance> tasks() {
        return get(TaskInstance.class);
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
