package org.kie.kogito.research.integration.tests.impl;

import io.smallrye.mutiny.Multi;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.jboss.logging.Logger;
import org.kie.kogito.research.application.api.Event;
import org.kie.kogito.research.application.api.MessageBus;
import org.reactivestreams.Publisher;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.function.Consumer;

@ApplicationScoped
public class SmallryeProcessorMessageBus implements MessageBus<Event> {
    private final static Logger LOGGER = Logger.getLogger(SmallryeProcessorMessageBus.class);

    @Inject
    @Channel("sink")
    Emitter<Event> sink;

    @Inject
    @Channel("source")
    Multi<Event> source;

    @PostConstruct
    void wire() {
        subscribe(e -> LOGGER.infof("Incoming %s", e));
    }


    public Publisher<Event> publisher() {
        return source;
    }

    @Override
    public void send(Event event) {
        LOGGER.infof("Outgoing %s", event);
        sink.send(event);
    }

    @Override
    public void subscribe(Consumer<Event> consumer) {
        source.subscribe().with(consumer);
    }
}