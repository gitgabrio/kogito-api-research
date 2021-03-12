package org.kie.kogito.research.application.core.impl;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.operators.multi.processors.BroadcastProcessor;
import org.kie.kogito.research.application.api.events.Event;
import org.kie.kogito.research.application.api.MessageBus;
import org.kie.kogito.research.application.api.events.ModelEvent;
import org.kie.kogito.research.application.api.ids.ModelId;
import org.kie.kogito.research.application.api.messages.ModelMessage;
import org.reactivestreams.Publisher;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class BroadcastProcessorMessageBus<T extends ModelId, E extends ModelMessage<T>, U extends ModelEvent<T, E>> implements MessageBus<T, E, U> {
    private final BroadcastProcessor<U> processor = BroadcastProcessor.create();
    private final ExecutorService executor = Executors.newCachedThreadPool();
    private final Multi<U> multi = processor.cache().emitOn(executor);

    public Publisher<U> publisher() {
        return processor;
    }

    @Override
    public void send(U event) {
        processor.onNext(event);
    }

    @Override
    public void subscribe(Consumer<U> consumer) {
        multi.subscribe().with(consumer);
    }
}