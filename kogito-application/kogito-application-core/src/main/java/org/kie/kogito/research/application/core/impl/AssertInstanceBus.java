package org.kie.kogito.research.application.core.impl;

import io.smallrye.mutiny.Multi;
import org.kie.kogito.research.application.api.MessageBus;
import org.kie.kogito.research.application.api.events.ModelInstanceEvent;
import org.kie.kogito.research.application.api.ids.Id;
import org.kie.kogito.research.application.api.ids.ModelId;
import org.kie.kogito.research.application.api.ids.ModelInstanceId;
import org.kie.kogito.research.application.api.ids.SimpleId;
import org.kie.kogito.research.application.api.messages.InstanceMessage;

import java.util.concurrent.CompletableFuture;
import java.util.function.Predicate;

public abstract class AssertInstanceBus<T extends ModelId, E extends ModelInstanceId, I extends InstanceMessage<T, E>, U extends ModelInstanceEvent<T, E, I>> {
    protected final Id self;
    protected final Multi<I> messages;
    protected final Multi<U> processor;
    protected final MessageBus<T, I, U> messageBus;

    public AssertInstanceBus(MessageBus<T, I, U> messageBus) {
        this.processor = Multi.createFrom().publisher(messageBus.publisher());
        this.messageBus = messageBus;


        this.self = new SimpleId();
        this.messages =
                processor.filter(e -> self.equals(e.targetId()))
//                        .map(U.class::cast)
                        .map(e -> e.payload())
                        .cache();
    }

    public <K extends I> CompletableFuture<K> expect(Class<K> expectedResponse) {
        var future =
                messages
                        .filter(expectedResponse::isInstance)
                        .map(expectedResponse::cast)
                        .toUni().subscribeAsCompletionStage();
        return future;
    }

    public <K extends I> CompletableFuture<K> expect(Class<K> expectedResponse, Predicate<K> predicate) {
        var future =
                messages
                        .filter(expectedResponse::isInstance)
                        .map(expectedResponse::cast)
                        .filter(predicate)
                        .toUni().subscribeAsCompletionStage();
        return future;
    }

    public class ExpectResponse {
        private final I message;

        public ExpectResponse(I message) {
            this.message = message;
        }

        public <K extends I> CompletableFuture<K> expect(Class<K> expectedResponse) {
            var future =
                    messages
                            .filter(expectedResponse::isInstance)
                            .map(expectedResponse::cast)
                            .toUni().subscribeAsCompletionStage();
            return future;
        }

        public CompletableFuture<I> expect() {
            var future =
                    messages
                            .map(e -> ((I) e))
                            .filter(e -> e.requestId().equals(message.requestId()))
                            .toUni().subscribeAsCompletionStage();
            return future;
        }

        public <K extends I> CompletableFuture<K> expect(Class<K> expectedResponse, Predicate<K> predicate) {
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
