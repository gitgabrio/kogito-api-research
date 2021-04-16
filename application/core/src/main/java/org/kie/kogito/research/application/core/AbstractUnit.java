package org.kie.kogito.research.application.core;

import java.util.HashMap;
import java.util.Map;

import org.kie.kogito.research.application.api.*;

public abstract class AbstractUnit<U extends Unit<U>> implements Unit<U> {

    private final UnitContainer<U> container;
    private final UnitId id;
    private final Map<Id, Instance<U>> instances = new HashMap<>();

    public AbstractUnit(UnitContainer<U> container, UnitId id) {
        this.container = container;
        this.id = id;
    }

    @Override
    public Application application() {
        return container.application();
    }

    @Override
    public UnitId id() {
        return id;
    }

    protected Instance<U> register(Instance<U> instance) {
        instances.put(instance.id(), instance);
        return instance;
    }

}
