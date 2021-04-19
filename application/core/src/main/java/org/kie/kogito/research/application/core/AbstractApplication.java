package org.kie.kogito.research.application.core;

import org.kie.kogito.research.application.api.Addressable;
import org.kie.kogito.research.application.api.AddressableContainer;
import org.kie.kogito.research.application.api.Application;
import org.kie.kogito.research.application.api.Id;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractApplication implements Application {
    private Id id = new UriId(null, "kogito-app");

    public Id id() {
        return id;
    }

    private final Map<Class<?>, AddressableContainer<?>> containers = new HashMap<>();

    protected <U extends Addressable, C extends AddressableContainer<U>> void register(Class<U> cls, C container) {
        containers.put(cls, container);
    }

    @Override
    public <U extends Addressable, C extends AddressableContainer<U>> C get(Class<U> cls) {
        return (C) containers.get(cls);
    }
}
