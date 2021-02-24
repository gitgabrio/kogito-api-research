package org.kie.kogito.research.application.core.impl;

import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;
import org.kie.kogito.research.application.api.Event;
import org.kie.kogito.research.application.api.MessageBus;

import java.util.function.Consumer;

public class VertxMessageBus implements MessageBus<Event> {
    EventBus eventBus;

    public VertxMessageBus(EventBus eventBus) {
        this.eventBus = eventBus;
    }


    @Override
    public void send(Event event) {
        eventBus.send("messages", event);
    }

    @Override
    public void subscribe(Consumer<Event> consumer) {
        eventBus.consumer("messages", m -> {
            System.out.println("TEST  -> "+m.body());
            Event body = (Event) m.body();
            consumer.accept(body);
            System.out.println("TEST2");

        });
    }
}
