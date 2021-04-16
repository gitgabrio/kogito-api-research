package org.kie.kogito.research.application.core;

import org.kie.kogito.research.application.api.*;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractAddressableContainer<T extends Addressable> implements AddressableContainer<T> {
    private final Map<Id, T> addressables = new HashMap<>();
    private final Id id;

    public AbstractAddressableContainer(Id parentId, String name) {
        this.id = new UriUnitId(parentId, name);
    }

    @Override
    public Id id() {
        return id;
    }

    protected T register(T addressable) {
        addressables.put(addressable.id(), addressable);
        return addressable;
    }

    @Override
    public T get(Id unitId) {
        return addressables.get(unitId);
    }

}
