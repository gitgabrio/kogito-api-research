package org.kie.kogito.research.application.core;

import java.util.HashMap;
import java.util.Map;

import org.kie.kogito.research.application.api.*;

public class SimpleUnitContainer<U extends Unit<U>> implements UnitContainer<U> {
    private final Map<RelativeId, U> units = new HashMap<>();
    private final Application application;
    private final Id id;

    public SimpleUnitContainer(Application application, RelativeId id) {
        this.application = application;
        this.id = UriId.of(application.id(), id);
    }

    // only for testing
    public <T extends U> T register(RelativeId id, T unit) {
        // needs to ensure the ID prefix == this.ID
        // ... but we should probably allow for multiple address
        // => ID maybe should not be an intrinsic property
        units.put(id, unit);
        return unit;
    }

    @Override
    public Application application() {
        return application;
    }

    @Override
    public U get(RelativeId unitId) {
        return units.get(unitId);
    }

    @Override
    public Id id() {
        return id;
    }

}
