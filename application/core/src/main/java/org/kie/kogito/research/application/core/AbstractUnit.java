package org.kie.kogito.research.application.core;

import java.util.HashMap;
import java.util.Map;

import org.kie.kogito.research.application.api.*;

public abstract class AbstractUnit<U extends Unit<U>, T extends Instance<U>> implements Unit<U> {

    private final UnitInstanceContainer<U, ? extends Instance<U>> container;
    private final Id id;
    private final Map<Id, Instance<U>> instances = new HashMap<>();

    public AbstractUnit(UnitInstanceContainer<U, ? extends Instance<U>> container, Id id) {
        this.container = container;
        this.id = id;
    }

    @Override
    public Id id() {
        return id;
    }

    @Override
    public UnitInstanceContainer<U, T> instances() {
        return (UnitInstanceContainer<U, T>) container;
    }

    protected Instance<U> register(Instance<U> instance) {
        instances.put(instance.id(), instance);
        return instance;
    }

}
