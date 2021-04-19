package org.kie.kogito.research.application.core;

import java.util.HashMap;
import java.util.Map;

import org.kie.kogito.research.application.api.*;

public abstract class AbstractUnit<U extends Unit<U>, I extends Instance<U>> implements Unit<U> {

    private final AddressableContainerFactory<I> container;
    private final Id id;
    private final Map<Id, Instance<U>> instances = new HashMap<>();

    public AbstractUnit(AddressableContainerFactory<I> container, Id id) {
        this.container = container;
        this.id = id;
    }

    @Override
    public Id id() {
        return id;
    }

    @Override
    public AddressableContainerFactory<I> instances() {
        return container;
    }

    protected Instance<U> register(Instance<U> instance) {
        instances.put(instance.id(), instance);
        return instance;
    }

}
