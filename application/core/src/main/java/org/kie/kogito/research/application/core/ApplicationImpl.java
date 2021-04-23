package org.kie.kogito.research.application.core;

import org.kie.kogito.research.application.api.*;

import java.util.Map;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

public class ApplicationImpl implements Application {
    private final Id id = UriId.of(null, RelativeUriId.of("kogito-app"));
    private final Map<Class<?>, AddressableContainer<?>> containers;

    public ApplicationImpl() {
        this.containers =
                ServiceLoader.load(AddressableContainerFactory.class)
                        .stream()
                        .map(ServiceLoader.Provider::get)
                        .collect(Collectors.toMap(
                                AddressableContainerFactory::type,
                                fact -> fact.create(id)));
    }

    @Override
    public <U extends AddressableContainer<?>> U get(Class<U> cls) {
        return (U) containers.get(cls);
    }
}
