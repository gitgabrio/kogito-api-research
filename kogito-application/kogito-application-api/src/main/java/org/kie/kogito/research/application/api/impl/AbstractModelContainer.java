package org.kie.kogito.research.application.api.impl;

import org.kie.kogito.research.application.api.*;
import org.kie.kogito.research.application.api.events.Event;
import org.kie.kogito.research.application.api.events.ModelEvent;
import org.kie.kogito.research.application.api.ids.ModelId;
import org.kie.kogito.research.application.api.ids.ModelInstanceId;
import org.kie.kogito.research.application.api.messages.ModelMessage;

import java.util.HashMap;
import java.util.Map;

public class AbstractModelContainer<T extends ModelId, I extends ModelMessage<T>, K  extends ModelEvent<T, I>, U extends Model<T, I, K>> implements ModelContainer<T, I, K, U> {
    private final Map<T, U> units = new HashMap<>();
    private final Application application;

    public AbstractModelContainer(Application application) {
        this.application = application;
    }

    protected U register(U unit) {
        units.put((T) unit.id(), unit);
        return unit;
    }

    @Override
    public Application application() {
        return application;
    }

    @Override
    public U get(T unitId) {
        return units.get(unitId);
    }

    @Override
    public void send(K event) {
        for (U model : units.values()) {
            final MessageBus<T, I, K> messageBus = model.messageBus();
            messageBus.send(event);
        }
    }
}
