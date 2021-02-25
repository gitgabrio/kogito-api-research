package org.kie.kogito.research.processes.core.impl;

import io.smallrye.mutiny.Multi;
import org.kie.kogito.research.application.api.Event;
import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.api.MessageBus;
import org.kie.kogito.research.application.api.impl.SimpleId;
import org.kie.kogito.research.application.api.messages.RequestId;
import org.kie.kogito.research.application.core.impl.BroadcastProcessorMessageBus;
import org.kie.kogito.research.processes.api.ProcessEvent;
import org.kie.kogito.research.processes.api.messages.ProcessMessages;

import java.util.concurrent.CompletableFuture;
import java.util.function.Predicate;

public class AssertBus {
    private final Id self;
    private final Multi<ProcessMessages.Message> messages;
    private final Multi<Event> processor;
    private final MessageBus<Event> messageBus;

    public AssertBus(MessageBus<Event> messageBus) {
        this.processor = Multi.createFrom().publisher(messageBus.publisher());
        this.messageBus = messageBus;


        this.self = new SimpleId();
        this.messages =
                processor.filter(e -> self.equals(e.targetId()))
                        .map(ProcessEvent.class::cast)
                        .map(ProcessEvent::payload)
                        .cache();
    }

    public ExpectResponse send(ProcessMessages.Message message) {
        messageBus.send(new SimpleProcessEvent(self, null, message));
        return new ExpectResponse(message);
    }

    public <E extends ProcessMessages.Message> CompletableFuture<E> expect(Class<E> expectedResponse) {
        var future =
                messages
                        .filter(expectedResponse::isInstance)
                        .map(expectedResponse::cast)
                        .toUni().subscribeAsCompletionStage();
        return future;
    }

    public <E extends ProcessMessages.Message> CompletableFuture<E> expect(Class<E> expectedResponse, Predicate<E> predicate) {
        var future =
                messages
                        .filter(expectedResponse::isInstance)
                        .map(expectedResponse::cast)
                        .filter(predicate)
                        .toUni().subscribeAsCompletionStage();
        return future;
    }

    public class ExpectResponse {
        private final ProcessMessages.Message message;

        public ExpectResponse(ProcessMessages.Message message) {
            this.message = message;
        }

        public <E extends ProcessMessages.Message> CompletableFuture<E> expect(Class<E> expectedResponse) {
            var future =
                    messages
                            .filter(expectedResponse::isInstance)
                            .map(expectedResponse::cast)
                            .toUni().subscribeAsCompletionStage();
            return future;
        }

        public CompletableFuture<ProcessMessages.ProcessMessage> expect() {
            var future =
                    messages
                            .map(e -> ((ProcessMessages.ProcessMessage) e))
                            .filter(e -> e.requestId().equals(message.requestId()))
                            .toUni().subscribeAsCompletionStage();
            return future;
        }

        public <E extends ProcessMessages.Message> CompletableFuture<E> expect(Class<E> expectedResponse, Predicate<E> predicate) {
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
