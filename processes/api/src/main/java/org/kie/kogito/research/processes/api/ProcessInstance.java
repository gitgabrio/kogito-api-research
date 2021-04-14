package org.kie.kogito.research.processes.api;

import org.kie.kogito.research.application.api.Context;
import org.kie.kogito.research.application.api.UnitInstance;
import org.kie.kogito.research.application.api.UnitInstanceContainer;

public interface ProcessInstance extends UnitInstance {
    Process unit();

    <T extends Context> T context(Class<T> cls);

    <T extends UnitInstanceContainer> T get(Class<T> container);
}
