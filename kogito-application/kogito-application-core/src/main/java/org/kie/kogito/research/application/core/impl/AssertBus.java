package org.kie.kogito.research.application.core.impl;

import io.smallrye.mutiny.Multi;
import org.kie.kogito.research.application.api.MessageBus;
import org.kie.kogito.research.application.api.events.ModelEvent;
import org.kie.kogito.research.application.api.ids.Id;
import org.kie.kogito.research.application.api.ids.ModelId;
import org.kie.kogito.research.application.api.ids.SimpleId;
import org.kie.kogito.research.application.api.messages.ModelMessage;

import java.util.concurrent.CompletableFuture;
import java.util.function.Predicate;

public abstract class AssertBus<T extends ModelId, E extends ModelMessage<T>, U extends ModelEvent<T, E>> {
    protected final Id self;
    protected final Multi<E> messages;
    protected final Multi<U> processor;
    protected final MessageBus<T, E, U> messageBus;

    public AssertBus(MessageBus<T, E, U> messageBus) {
        this.processor = Multi.createFrom().publisher(messageBus.publisher());
        this.messageBus = messageBus;


        this.self = new SimpleId();
        this.messages =
                processor.filter(e -> self.equals(e.targetId()))
//                        .map(U.class::cast)
                        .map(e -> e.payload())
                        .cache();
    }
//
//    public ExpectResponse send(E message) {
//        messageBus.send(SimpleEvent.of(self, null, message));
//        return new ExpectResponse(message);
//    }

    public <I extends E> CompletableFuture<I> expect(Class<I> expectedResponse) {
        var future =
                messages
                        .filter(expectedResponse::isInstance)
                        .map(expectedResponse::cast)
                        .toUni().subscribeAsCompletionStage();
        return future;
    }

    public <I extends E> CompletableFuture<I> expect(Class<I> expectedResponse, Predicate<I> predicate) {
        var future =
                messages
                        .filter(expectedResponse::isInstance)
                        .map(expectedResponse::cast)
                        .filter(predicate)
                        .toUni().subscribeAsCompletionStage();
        return future;
    }

    public class ExpectResponse {
        private final E message;

        public ExpectResponse(E message) {
            this.message = message;
        }

        public <I extends E> CompletableFuture<I> expect(Class<I> expectedResponse) {
            var future =
                    messages
                            .filter(expectedResponse::isInstance)
                            .map(expectedResponse::cast)
                            .toUni().subscribeAsCompletionStage();
            return future;
        }

        public CompletableFuture<E> expect() {
            var future =
                    messages
                            .map(e -> ((E) e))
                            .filter(e -> e.requestId().equals(message.requestId()))
                            .toUni().subscribeAsCompletionStage();
            return future;
        }

        public <I extends E> CompletableFuture<I> expect(Class<I> expectedResponse, Predicate<I> predicate) {
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
