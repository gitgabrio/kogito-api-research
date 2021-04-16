package org.kie.kogito.research.application.core;

import org.kie.kogito.research.application.api.Application;
import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.api.Unit;
import org.kie.kogito.research.application.api.UnitContainer;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractApplication implements Application {
    private Id id = new UriId(null, "kogito-app");

    public Id id() {
        return id;
    }

    private final Map<Class<?>, UnitContainer<?>> containers = new HashMap<>();

    protected <U extends Unit<U>, T extends UnitContainer<U>> void register(Class<U> cls, T container) {
        containers.put(cls, container);
    }

    @Override
    public <T extends Unit<T>> UnitContainer<T> get(Class<T> ctr) {
        return (UnitContainer<T>) containers.get(ctr);
    }
}
