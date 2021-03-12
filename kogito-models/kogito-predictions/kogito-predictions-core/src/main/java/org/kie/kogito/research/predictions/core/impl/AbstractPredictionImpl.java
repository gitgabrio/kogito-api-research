package org.kie.kogito.research.predictions.core.impl;

import org.kie.kogito.research.application.api.messages.ModelExecuteMessage;
import org.kie.kogito.research.predictions.api.PredictionEvent;
import org.kie.kogito.research.predictions.api.PredictionMessageBus;
import org.kie.kogito.research.predictions.api.ids.PredictionId;
import org.kie.logito.models.api.ModelExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractPredictionImpl implements ModelExecutor<PredictionId> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractPredictionImpl.class);

    private final PredictionId processId;

    protected AbstractPredictionImpl(String processId) {
        this.processId = SimplePredictionId.fromString(processId);
    }

    @Override
    public PredictionId getId() {
        return processId;
    }

    public void receive(PredictionMessageBus messageBus, PredictionEvent pEvent) {
        LOGGER.info("receive {} {}", messageBus, pEvent);
        pEvent.payload().as(ModelExecuteMessage.class)
                .ifPresent(e -> {
                    ModelExecuteMessage message = (ModelExecuteMessage) e;
                    LOGGER.info("receiving ModelExecuteMessage");
                    if (message.modelId() instanceof PredictionId) {
                        LOGGER.info("send ModelExecutedMessage");
                        PredictionExecutedMessage predictionExecutedMessage = new PredictionExecutedMessage(message.requestId(), (PredictionId) message.modelId());
                        PredictionExecutedEvent predictionEvent = new PredictionExecutedEvent(message.requestId(),  (PredictionId) message.modelId(), predictionExecutedMessage);
                        messageBus.send(predictionEvent);
                    }
                });
    }


}
