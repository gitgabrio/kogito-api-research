package org.kie.kogito.research.application.core.impl;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.operators.multi.processors.BroadcastProcessor;
import org.kie.kogito.research.application.api.Event;
import org.kie.kogito.research.application.api.MessageBus;
import org.reactivestreams.Publisher;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class BroadcastProcessorMessageBus implements MessageBus<Event> {
    private final BroadcastProcessor<Event> processor = BroadcastProcessor.create();
    private final ExecutorService executor = Executors.newCachedThreadPool();
    private final Multi<Event> multi = processor.cache().emitOn(executor);

    public Publisher<Event> publisher() {
        return processor;
    }

    @Override
    public void send(Event event) {
        processor.onNext(event);
    }

    @Override
    public void subscribe(Consumer<Event> consumer) {
        multi.subscribe().with(consumer);
    }
}