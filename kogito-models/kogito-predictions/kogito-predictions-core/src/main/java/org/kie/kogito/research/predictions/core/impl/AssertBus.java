package org.kie.kogito.research.predictions.core.impl;

import io.smallrye.mutiny.Multi;
import org.kie.kogito.research.application.api.ids.Id;
import org.kie.kogito.research.application.api.ids.SimpleId;
import org.kie.kogito.research.predictions.api.PredictionEvent;
import org.kie.kogito.research.predictions.api.PredictionMessage;
import org.kie.kogito.research.predictions.api.PredictionMessageBus;

import java.util.concurrent.CompletableFuture;
import java.util.function.Predicate;

public class AssertBus {
    private final Id self;
    private final Multi<PredictionMessage> messages;
    private final Multi<PredictionEvent> processor;
    private final PredictionMessageBus messageBus;

    public AssertBus(PredictionMessageBus messageBus) {
        this.processor = Multi.createFrom().publisher(messageBus.publisher());
        this.messageBus = messageBus;


        this.self = new SimpleId();
        this.messages =
                processor.filter(e -> self.equals(e.targetId()))
                        .map(PredictionEvent.class::cast)
                        .map(PredictionEvent::payload)
                        .cache();
    }

    public ExpectResponse send(PredictionExecutedMessage message) {
        messageBus.send(new PredictionExecutedEvent(message.requestId(), null, message));
        return new ExpectResponse(message);
    }

    public <E extends PredictionExecutedMessage> CompletableFuture<E> expect(Class<E> expectedResponse) {
        var future =
                messages
                        .filter(expectedResponse::isInstance)
                        .map(expectedResponse::cast)
                        .toUni().subscribeAsCompletionStage();
        return future;
    }

    public <E extends PredictionExecutedMessage> CompletableFuture<E> expect(Class<E> expectedResponse, Predicate<E> predicate) {
        var future =
                messages
                        .filter(expectedResponse::isInstance)
                        .map(expectedResponse::cast)
                        .filter(predicate)
                        .toUni().subscribeAsCompletionStage();
        return future;
    }

    public class ExpectResponse {
        private final PredictionExecutedMessage message;

        public ExpectResponse(PredictionExecutedMessage message) {
            this.message = message;
        }

        public <E extends PredictionExecutedMessage> CompletableFuture<E> expect(Class<E> expectedResponse) {
            var future =
                    messages
                            .filter(expectedResponse::isInstance)
                            .map(expectedResponse::cast)
                            .toUni().subscribeAsCompletionStage();
            return future;
        }

        public CompletableFuture<PredictionExecutedMessage> expect() {
            var future =
                    messages
                            .filter(e -> e.requestId().equals(message.requestId()))
                            .map(e -> new PredictionExecutedMessage(e.requestId(), e.modelId()))
                            .toUni().subscribeAsCompletionStage();
            return future;
        }

        public <E extends PredictionExecutedMessage> CompletableFuture<E> expect(Class<E> expectedResponse, Predicate<E> predicate) {
            var future =
                    messages
                            .filter(expectedResponse::isInstance)
                            .map(expectedResponse::cast)
                            .filter(predicate)
                            .toUni().subscribeAsCompletionStage();
            return future;
        }
    }
}
