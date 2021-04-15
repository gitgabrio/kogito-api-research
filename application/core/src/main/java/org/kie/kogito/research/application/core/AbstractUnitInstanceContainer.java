package org.kie.kogito.research.application.core;

import org.kie.kogito.research.application.api.*;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractUnitInstanceContainer<U extends UnitInstance> implements UnitInstanceContainer<U> {
    private final Map<UnitInstanceId, U> units = new HashMap<>();
    private final Id id;

    public AbstractUnitInstanceContainer(Id parentId, String name) {
        this.id = new UriUnitId(parentId, name);
    }

    protected <T extends U> T register(T unit) {
        units.put(unit.id(), unit);
        return unit;
    }

    @Override
    public U get(UnitInstanceId unitId) {
        return units.get(unitId);
    }

    @Override
    public Id id() {
        return id;
    }
}
