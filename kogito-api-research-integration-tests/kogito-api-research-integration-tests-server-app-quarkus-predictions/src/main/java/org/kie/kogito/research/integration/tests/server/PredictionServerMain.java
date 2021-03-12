package org.kie.kogito.research.integration.tests.server;


import org.kie.kogito.bus.server.api.AbstractModelServer;
import org.kie.kogito.research.predictions.api.PredictionEvent;
import org.kie.kogito.research.predictions.api.PredictionMessage;
import org.kie.kogito.research.predictions.api.PredictionMessageBus;
import org.kie.kogito.research.predictions.api.ids.PredictionId;
import org.kie.kogito.research.predictions.core.impl.AbstractPredictionImpl;
import org.kie.kogito.research.predictions.core.impl.PredictionModelNoExecutorMessage;
import org.kie.kogito.research.predictions.core.impl.PredictionModelNoSuchMessage;
import org.kie.kogito.research.predictions.core.impl.PredictionResponseEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PredictionServerMain extends AbstractModelServer<PredictionId, PredictionMessage, AbstractPredictionImpl, PredictionEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(PredictionServerMain.class);

        public PredictionServerMain(PredictionMessageBus messageBus, List<AbstractPredictionImpl> modelExecutors) {
        super(messageBus, modelExecutors);
        LOGGER.info("PredictionServerMain constructor invoked with {} {}", messageBus, modelExecutors);
    }

    @Override
    public void receive(AbstractPredictionImpl modelExecutor, PredictionEvent toReceive) {
        LOGGER.info("receive {} {}", modelExecutor, toReceive);
        modelExecutor.receive((PredictionMessageBus)messageBus, toReceive);
    }

    @Override
    protected PredictionEvent getNoExecutorReply(PredictionEvent event) {
        LOGGER.info("getNoExecutorReply {}", event);
        PredictionModelNoExecutorMessage message = new PredictionModelNoExecutorMessage(event.payload().requestId(), event.getModelId());
        return new PredictionResponseEvent(event.payload().requestId(), event.getModelId(), message);
    }

    @Override
    protected PredictionEvent getNoMatchingExecutorReply(PredictionEvent event) {
        LOGGER.info("getNoMatchingExecutorReply {}", event);
        PredictionModelNoSuchMessage message = new PredictionModelNoSuchMessage(event.payload().requestId(), event.getModelId());
        return new PredictionResponseEvent(event.payload().requestId(), event.getModelId(), message);
    }

}
