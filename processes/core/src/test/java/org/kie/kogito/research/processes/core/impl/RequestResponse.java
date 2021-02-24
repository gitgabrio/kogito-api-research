package org.kie.kogito.research.processes.core.impl;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.operators.multi.processors.BroadcastProcessor;
import org.kie.kogito.research.application.api.Event;
import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.api.impl.SimpleId;
import org.kie.kogito.research.application.core.impl.BroadcastProcessorMessageBus;
import org.kie.kogito.research.processes.api.ProcessEvent;
import org.kie.kogito.research.processes.api.messages.ProcessMessages;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.Queue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedQueue;

public class RequestResponse {
    private final Id self;
    private final Multi<ProcessMessages.Message> messages;
    private BroadcastProcessor<Event> processor;

    RequestResponse(BroadcastProcessorMessageBus messageBus) {
        this.processor = messageBus.processor();
        this.self = new SimpleId();
        this.messages =
                processor.filter(e -> e.targetId() == self)
                        .invoke(e -> System.out.println(e))
                        .map(ProcessEvent.class::cast)
                        .map(ProcessEvent::payload)
                        .cache();
    }

    RequestResponse send(ProcessMessages.Message message) {
        processor.onNext(new SimpleProcessEvent(self, null, message));
        return this;
    }

    public <E extends ProcessMessages.Message> CompletableFuture<E> expect(Class<E> expectedResponse) {
        var future =
                messages
                        .filter(expectedResponse::isInstance)
                        .map(expectedResponse::cast)
                        .toUni().subscribeAsCompletionStage();
        return future;
    }

}
