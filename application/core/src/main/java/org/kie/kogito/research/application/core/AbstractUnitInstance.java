package org.kie.kogito.research.application.core;

import org.kie.kogito.research.application.api.*;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractUnitInstance<T extends Unit<T>> implements Instance<T> {

    private final Id id;
    private final Map<Class<?>, AddressableContainer<?>> containers;

    public AbstractUnitInstance(Id id) {
        this.id = id;
        this.containers = new HashMap<>();
    }

    @Override
    public Id id() {
        return id;
    }

    public <T extends Context> T context(Class<T> cls) {
        return null; //cls.cast(context); // should remap if they don't match!
    }

//    protected final <U extends Unit<U>, C extends UnitInstanceContainer<U, ? extends Instance<U>>> void register(Class<C> cls, C ctr) {
    protected final <U extends Addressable, C extends AddressableContainer<U>> void register(Class<C> cls, C ctr) {
        containers.put(cls, ctr);
    }

    @Override
    public <U extends Addressable, C extends AddressableContainer<U>> C get(Class<C> cls) {
        return (C) containers.get(cls);
    }
}
