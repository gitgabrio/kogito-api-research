package org.kie.kogito.research.integration.tests.server;

import org.kie.kogito.research.integration.tests.impl.SmallryeProcessorMessageBus;
import org.kie.kogito.research.predictions.api.PredictionEvent;
import org.kie.kogito.research.predictions.api.PredictionMessage;
import org.kie.kogito.research.predictions.api.PredictionMessageBus;
import org.kie.kogito.research.predictions.api.ids.PredictionId;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PredictionSmallryeMessageBus extends SmallryeProcessorMessageBus<PredictionId, PredictionMessage, PredictionEvent> implements PredictionMessageBus {
}