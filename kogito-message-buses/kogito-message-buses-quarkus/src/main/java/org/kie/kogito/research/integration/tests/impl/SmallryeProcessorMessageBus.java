package org.kie.kogito.research.integration.tests.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.subscription.Cancellable;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.jboss.logging.Logger;
import org.kie.kogito.research.application.api.MessageBus;
import org.kie.kogito.research.application.api.events.ModelEvent;
import org.kie.kogito.research.application.api.ids.ModelId;
import org.kie.kogito.research.application.api.messages.ModelMessage;
import org.reactivestreams.Publisher;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public abstract class SmallryeProcessorMessageBus<T extends ModelId, E extends ModelMessage<T>, U extends ModelEvent<T, E>> implements MessageBus<T, E, U> {
    @Inject
    ObjectMapper objectMapper;

    private static final Logger LOGGER = Logger.getLogger(SmallryeProcessorMessageBus.class);

    private Map<Consumer<U>, Cancellable> cancellableConsumers = new HashMap<>();

    @Inject
    @Channel("sink")
    Emitter<U> sink;

    @Inject
    @Channel("source")
    Multi<U> source;

    @PostConstruct
    void wire() {
        subscribe(e -> LOGGER.infof("Incoming %s", e));
    }


    public Publisher<U> publisher() {
        return source;
    }

    @Override
    public void send(U event) {
        LOGGER.infof("Outgoing %s", event);
        sink.send(event);
    }

    @Override
    public void subscribe(Consumer<U> consumer) {
        cancellableConsumers.put(consumer, source.subscribe().with(consumer));
    }

    @Override
    public void unSubscribe(Consumer<U> consumer) {
        cancellableConsumers.get(consumer).cancel();
        cancellableConsumers.remove(consumer);
    }
}