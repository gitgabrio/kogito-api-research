package org.kie.kogito.research.decisions.core.services.impl;

import org.kie.kogito.research.application.api.EvaluationServiceFactory;
import org.kie.kogito.research.decisions.api.Decision;

public interface DecisionServices {
    EvaluationServiceFactory<Decision, DecisionDecoratorImpl> local =
            id -> new DecisionDecoratorImpl(new DecisionEvaluationServiceImpl(), id);

}
