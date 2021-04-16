package org.kie.kogito.research.application.core;

import java.util.HashMap;
import java.util.Map;

import org.kie.kogito.research.application.api.*;

public class SimpleUnitContainer<U extends Unit> implements UnitContainer<U> {
    private final Map<Id, U> units = new HashMap<>();
    private final Application application;
    private final Id id;

    public SimpleUnitContainer(Application application, String name) {
        this.application = application;
        this.id = new UriUnitId(application.id(), name);
    }

    protected <T extends U> T register(T unit) {
        units.put(unit.id(), unit);
        return unit;
    }

    @Override
    public Application application() {
        return application;
    }

    @Override
    public U get(UnitId unitId) {
        return units.get(unitId);
    }

    @Override
    public Id id() {
        return id;
    }

}
