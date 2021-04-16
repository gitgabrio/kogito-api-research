package org.kie.kogito.research.application.core;

import org.kie.kogito.research.application.api.*;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractUnitInstanceContainer<U extends Unit> implements UnitInstanceContainer<U> {
    private final Map<Id, Instance<U>> units = new HashMap<>();
    private final Id id;

    public AbstractUnitInstanceContainer(Id parentId, String name) {
        this.id = new UriUnitId(parentId, name);
    }

    protected <T extends Instance<U>> T register(T unitInstance) {
        units.put(unitInstance.id(), unitInstance);
        return unitInstance;
    }

    @Override
    public Instance<U> create(Context ctx) {
        return register(create0(ctx));
    }

    public abstract Instance<U> create0(Context ctx);

    @Override
    public Instance<U> get(Id unitId) {
        return units.get(unitId);
    }

    @Override
    public Id id() {
        return id;
    }
}
