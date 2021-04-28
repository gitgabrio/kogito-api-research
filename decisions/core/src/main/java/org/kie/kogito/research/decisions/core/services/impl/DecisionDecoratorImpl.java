package org.kie.kogito.research.decisions.core.services.impl;

import org.kie.kogito.research.application.api.Context;
import org.kie.kogito.research.decisions.api.Decision;

public class DecisionDecoratorImpl {
    private final DecisionEvaluationServiceImpl decisionEvaluationService;
    private final Decision identifier;

    public DecisionDecoratorImpl(DecisionEvaluationServiceImpl decisionEvaluationService, Decision identifier) {
        this.decisionEvaluationService = decisionEvaluationService;
        this.identifier = identifier;
    }

    public void evaluate(Context context) {
        decisionEvaluationService.evaluate(identifier, context);
    }
}
