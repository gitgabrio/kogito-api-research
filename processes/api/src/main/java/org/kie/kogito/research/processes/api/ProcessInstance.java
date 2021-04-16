package org.kie.kogito.research.processes.api;

import org.kie.kogito.research.application.api.*;

public interface ProcessInstance extends Instance<Process> {
    // context
    <T extends Context> T variables(Class<T> cls);

    UnitInstanceContainer<Task, TaskInstance> tasks();

    void start();

    void abort();

    <T extends Context> T update(T context);

    void send(Event signalEvent);

}
