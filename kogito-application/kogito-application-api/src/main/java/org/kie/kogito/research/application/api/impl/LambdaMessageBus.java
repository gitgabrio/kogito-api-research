package org.kie.kogito.research.application.api.impl;

import org.kie.kogito.research.application.api.MessageBus;
import org.kie.kogito.research.application.api.events.ModelEvent;
import org.kie.kogito.research.application.api.ids.ModelId;
import org.kie.kogito.research.application.api.messages.ModelMessage;

import java.util.function.Consumer;

public class LambdaMessageBus<T extends ModelId, E extends ModelMessage<T>, U extends ModelEvent<T, E>> implements MessageBus<T, E, U> {
    private final Consumer<U> consumer;

    public LambdaMessageBus(Consumer<U> consumer) {
        this.consumer = consumer;
    }

    @Override
    public void send(U event) {
        consumer.accept(event);
    }

    @Override
    public void subscribe(Consumer<U> consumer) {
        //no op
    }


}
