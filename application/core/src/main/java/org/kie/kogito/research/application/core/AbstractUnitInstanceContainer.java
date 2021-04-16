package org.kie.kogito.research.application.core;

import org.kie.kogito.research.application.api.*;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractUnitInstanceContainer<U extends Unit, I extends Instance<U>> implements UnitInstanceContainer<U, I> {
    private final Map<Id, I> units = new HashMap<>();
    private final Id id;

    public AbstractUnitInstanceContainer(Id parentId, String name) {
        this.id = new UriUnitId(parentId, name);
    }

    protected I register(I unitInstance) {
        units.put(unitInstance.id(), unitInstance);
        return unitInstance;
    }

    @Override
    public I create(Context ctx) {
        return register(create0(ctx));
    }

    public abstract I create0(Context ctx);

    @Override
    public I get(Id unitId) {
        return units.get(unitId);
    }

    @Override
    public Id id() {
        return id;
    }
}
