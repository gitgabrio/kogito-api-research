package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.*;
import org.kie.kogito.research.application.core.AbstractUnitInstance;
import org.kie.kogito.research.application.core.AbstractUnitInstanceContainer;
import org.kie.kogito.research.application.core.UriUnitId;
import org.kie.kogito.research.processes.api.Process;
import org.kie.kogito.research.processes.api.ProcessInstance;
import org.kie.kogito.research.processes.api.Task;
import org.kie.kogito.research.processes.api.TaskInstance;

import java.util.UUID;

public class ProcessInstanceImpl extends AbstractUnitInstance implements ProcessInstance {

    public ProcessInstanceImpl(UnitInstanceId id, Process unit, Context context) {
        super(id, unit, context);
    }

    @Override
    public Process unit() {
        return (Process) super.unit();
    }

    @Override
    public UnitInstanceContainer<TaskInstance> tasks() {
        return new AbstractUnitInstanceContainer<TaskInstance>(this.id(), "tasks") {

            @Override
            public TaskInstance get(UnitInstanceId unitId) {
                // recreate just for mock
                return create(null);
            }

            @Override
            public TaskInstance create(Context ctx) {
                return new HumanTaskInstance(this.id());
            }
        };
    }

    @Override
    public <T extends Context> T variables(Class<T> cls) {
        System.out.println("VARIABLES: "+ id());
        return null;
    }

    @Override
    public void start() {
        System.out.println("START: "+id());
    }

    @Override
    public void abort() {
        System.out.println("ABORT: "+id());
    }

    @Override
    public <T extends Context> T update(T context) {
        return null;
    }

    @Override
    public void send(Event signalEvent) {
        System.out.printf("SEND: %s -- %s\n", id(), signalEvent);
    }

    @Override
    public void complete() {
        System.out.printf("COMPLETE: %s\n", id());

    }

}
