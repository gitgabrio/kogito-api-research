package org.kie.kogito.research.processes.api;

import org.kie.kogito.research.application.api.*;

public interface ProcessInstance extends Instance<Process> {
    Process unit();

    // context
    <T extends Context> T variables(Class<T> cls);

    // instead of tasks() ?
    // <T extends UnitInstance> UnitInstanceContainer<T> get(Class<T> container);

    UnitInstanceContainer<Task, TaskInstance> tasks();

    void start();

    void abort();

    <T extends Context> T update(T context);

    void send(Event signalEvent);

}
