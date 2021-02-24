package org.kie.kogito.research.integration.tests.impl;

import io.smallrye.mutiny.Multi;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.kie.kogito.research.application.api.Event;
import org.kie.kogito.research.application.api.MessageBus;
import org.reactivestreams.Publisher;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.function.Consumer;

@ApplicationScoped
public class SmallryeProcessorMessageBus implements MessageBus<Event> {

    @Inject @Channel("sink") Emitter<Event> incoming;

    @Inject @Channel("source") Multi<Event> source;

    public Publisher<Event> publisher() {
        return source;
    }

    @Override
    public void send(Event event) {
        incoming.send(event);
    }

    @Override
    public void subscribe(Consumer<Event> consumer) {
        source.subscribe().with(consumer);
    }
}