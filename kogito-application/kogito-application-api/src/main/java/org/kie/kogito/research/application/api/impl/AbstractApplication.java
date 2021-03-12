package org.kie.kogito.research.application.api.impl;

import java.util.HashMap;
import java.util.Map;

import org.kie.kogito.research.application.api.Application;
import org.kie.kogito.research.application.api.Model;
import org.kie.kogito.research.application.api.events.Event;
import org.kie.kogito.research.application.api.ModelContainer;
import org.kie.kogito.research.application.api.events.ModelEvent;
import org.kie.kogito.research.application.api.ids.ModelId;
import org.kie.kogito.research.application.api.messages.ModelMessage;

public abstract class AbstractApplication<T extends ModelId, E extends ModelMessage<T>, U extends ModelEvent<T, E>, I extends Model<T, E, U>, K extends ModelContainer<T, E, U, I>> implements Application<T, E, U, I , K> {

    private final Map<Class<?>, K> containers = new HashMap<>();

    protected void register(K container) {
        containers.put(container.getClass(), container);
    }

    @Override
    public void send(U event) {
        for (K ctr : containers.values()) {
            ctr.send(event);
        }
    }

    @Override
    public K get(Class<K> ctr) {
        return containers.get(ctr);
    }
}
