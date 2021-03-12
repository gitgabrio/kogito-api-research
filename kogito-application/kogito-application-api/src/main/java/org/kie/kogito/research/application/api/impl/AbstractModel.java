package org.kie.kogito.research.application.api.impl;

import org.kie.kogito.research.application.api.Application;
import org.kie.kogito.research.application.api.MessageBus;
import org.kie.kogito.research.application.api.Model;
import org.kie.kogito.research.application.api.events.Event;
import org.kie.kogito.research.application.api.events.ModelEvent;
import org.kie.kogito.research.application.api.ids.ModelId;
import org.kie.kogito.research.application.api.messages.ModelMessage;

public abstract class AbstractModel<T extends ModelId, E extends ModelMessage<T>, U extends ModelEvent<T, E>> implements Model<T, E, U> {

    private final T id;


    public AbstractModel(T id) {
        this.id = id;
    }

    @Override
    public Application application() {
        return null;
    }

    @Override
    public T id() {
        return id;
    }


    @Override
    public MessageBus<T, E, U> messageBus() {
        return this::send;
    }

    abstract void send(U event);
}
