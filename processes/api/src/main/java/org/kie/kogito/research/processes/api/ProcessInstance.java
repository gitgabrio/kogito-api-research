package org.kie.kogito.research.processes.api;

import org.kie.kogito.research.application.api.Context;
import org.kie.kogito.research.application.api.Event;
import org.kie.kogito.research.application.api.UnitInstance;
import org.kie.kogito.research.application.api.UnitInstanceContainer;

public interface ProcessInstance extends UnitInstance {
    Process unit();

    // context
    <T extends Context> T variables(Class<T> cls);

    // instead of tasks() ?
    // <T extends UnitInstance> UnitInstanceContainer<T> get(Class<T> container);

    UnitInstanceContainer<TaskInstance> tasks();

    void start();

    void abort();

    <T extends Context> T update(T context);

    void send(Event signalEvent);

}
