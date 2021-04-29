package org.kie.kogito.research.application.core;

import org.kie.kogito.research.application.api.Addressable;
import org.kie.kogito.research.application.api.AddressableContainer;
import org.kie.kogito.research.application.api.Application;
import org.kie.kogito.research.application.api.Id;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractApplication implements Application {
    private Id id = UriId.parse("kogito://local-app");

    public Id id() {
        return id;
    }

    private final Map<Class<?>, Addressable> addressables = new HashMap<>();

    protected <U extends AddressableContainer<?>> void register(Class<U> cls, U container) {
        addressables.put(cls, container);
    }

    public <U extends AddressableContainer<?>> U get(Class<U> cls) {
        return (U) addressables.get(cls);
    }
}
