package org.kie.kogito.research.processes.api;

import org.kie.kogito.research.application.api.Context;
import org.kie.kogito.research.application.api.Unit;
import org.kie.kogito.research.application.api.UnitInstanceContainer;

public interface Process extends Unit {
    @Override ProcessInstance createInstance(Class<? extends Context> ctx);

    UnitInstanceContainer<ProcessInstance> instances();
}
