package org.kie.kogito.research.application.core;

import org.kie.kogito.research.application.api.*;

public abstract class AbstractUnitInstance implements UnitInstance {

    private final UnitInstanceId id;
    private final Unit unit;
    private final Context context;

    public AbstractUnitInstance(UnitInstanceId id, Unit unit, Context context) {
        this.id = id;
        this.unit = unit;
        this.context = context;
    }

    @Override
    public UnitInstanceId id() {
        return id;
    }

    @Override
    public Unit unit() {
        return unit;
    }

    public <T extends Context> T context(Class<T> cls) {
        return null;// cls.cast(context); // should remap if they don't match!
    }

}
