package org.kie.kogito.research.application.core;

import org.kie.kogito.research.application.api.*;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractAddressableContainer<T extends Addressable> implements AddressableContainer<T> {
    private final Map<RelativeId, T> addressables = new HashMap<>();
    private final Id id;

    public AbstractAddressableContainer(Id parentId, String name) {
        this.id = new UriId(parentId, name);
    }

    @Override
    public Id id() {
        return id;
    }

    protected T register(T addressable) {
        addressables.put(addressable.id().segment(), addressable);
        return addressable;
    }

    @Override
    public T get(RelativeId unitId) {
        return addressables.get(unitId);
    }

}
