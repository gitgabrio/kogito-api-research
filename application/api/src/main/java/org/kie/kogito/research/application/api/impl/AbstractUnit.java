package org.kie.kogito.research.application.api.impl;

import java.util.HashMap;
import java.util.Map;

import org.kie.kogito.research.application.api.*;

public abstract class AbstractUnit implements Unit {

    private final UnitContainer container;
    private final UnitId id;
    private final Map<UnitInstanceId, UnitInstance> instances = new HashMap<>();

    public AbstractUnit(UnitContainer container, UnitId id) {
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

    protected UnitInstance register(UnitInstance instance) {
        instances.put(instance.id(), instance);
        return instance;
    }

}
