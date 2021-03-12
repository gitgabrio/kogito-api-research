package org.kie.kogito.research.integration.tests.server;

import org.kie.kogito.research.predictions.core.impl.AbstractPredictionImpl;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PredictionImpl extends AbstractPredictionImpl {



    public PredictionImpl() {
        super("PredictionImplId"); // <-  "PredictionImplId" to be replaced by code-generation
    }

}
