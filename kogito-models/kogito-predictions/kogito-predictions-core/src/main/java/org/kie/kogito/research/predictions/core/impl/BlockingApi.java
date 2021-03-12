package org.kie.kogito.research.predictions.core.impl;

import org.kie.kogito.research.predictions.api.PredictionMessageBus;

public class BlockingApi {
    AssertBus assertBus;

    public BlockingApi(PredictionMessageBus messageBus) {
        this.assertBus = new AssertBus(messageBus);
    }




}
