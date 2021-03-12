package org.kie.kogito.research.application.api.impl;

import org.kie.kogito.research.application.api.MessageBus;
import org.kie.kogito.research.application.api.Model;
import org.kie.kogito.research.application.api.ModelContainer;
import org.kie.kogito.research.application.api.ModelInstance;
import org.kie.kogito.research.application.api.events.ModelInstanceEvent;
import org.kie.kogito.research.application.api.ids.ModelId;
import org.kie.kogito.research.application.api.ids.ModelInstanceId;
import org.kie.kogito.research.application.api.messages.InstanceMessage;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractInstancedModel<T extends ModelId, E extends ModelInstanceId, I extends InstanceMessage<T, E>, K extends ModelInstanceEvent<T, E, I>, U extends ModelInstance<T, E, I, K>> extends AbstractModel<T, I, K> {

    private final ModelContainer<T, I, K, Model<T, I, K>> container;
    private final Map<E, U> instances = new HashMap<>();

    public AbstractInstancedModel(ModelContainer container, T id) {
        super(id);
        this.container = container;
    }


    protected U register(U instance) {
        instances.put(instance.instanceId(), instance);
        return instance;
    }

    public Collection<U> instances() {
        return instances.values();
    }

    public void send(K event) {
        for (ModelInstance<T, E, I, K> instance : instances.values()) {
            if (event.targetId() == null ||
                    event.targetId().equals(this.id()) ||
                    event.targetId() instanceof ModelInstanceId) {
                MessageBus<T, I, K> messageBus = instance.messageBus();
                messageBus.send(event);
            }
        }
    }
}
