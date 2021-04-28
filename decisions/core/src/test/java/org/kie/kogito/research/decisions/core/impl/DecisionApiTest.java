package org.kie.kogito.research.decisions.core.impl;

import org.junit.jupiter.api.Test;
import org.kie.kogito.research.application.api.Context;
import org.kie.kogito.research.application.api.RelativeId;
import org.kie.kogito.research.application.core.ApplicationImpl;
import org.kie.kogito.research.decisions.api.DecisionContainer;
import org.kie.kogito.research.decisions.core.DecisionId;
import org.kie.kogito.research.decisions.core.services.impl.DecisionEvaluationServiceImpl;
import org.kie.kogito.research.decisions.core.services.impl.DecisionServices;

public class DecisionApiTest {
    @Test
    void test() {
        class Person implements Context {}

        RelativeId dmnId =
                DecisionId.of(
                        "http://www.redhat.com/_c7328033-c355-43cd-b616-0aceef80e52a",
                        "dmn-movieticket-ageclassification");

        var application = new ApplicationImpl();
        var decision =
                application
                        .get(DecisionContainer.class)
                        .get(dmnId);

        var decisionService = new DecisionEvaluationServiceImpl();
        decisionService.evaluate(decision, new Person());

        // fluent version (if desired)
        application
                .get(DecisionContainer.class)
                .get(dmnId)
                .eval(DecisionServices.local)
                .evaluate(new Person());

    }

}
