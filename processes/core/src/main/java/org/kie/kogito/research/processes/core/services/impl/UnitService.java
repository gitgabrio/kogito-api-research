package org.kie.kogito.research.processes.core.services.impl;

import org.kie.kogito.research.application.api.EvaluationServiceFactory;
import org.kie.kogito.research.application.api.Unit;

public interface UnitService {

    static <T extends Unit> EvaluationServiceFactory<T, UnitDecorator<T>> locally() {
        return u -> new UnitDecorator<>();
    }
}
