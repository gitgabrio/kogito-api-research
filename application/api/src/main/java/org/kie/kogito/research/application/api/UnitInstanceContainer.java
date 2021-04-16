package org.kie.kogito.research.application.api;

public interface UnitInstanceContainer<T extends Unit<T>, I extends Instance<T>> extends AddressableContainer<I> {
    Id id();
    I get(Id instanceId);
    I create(Context ctx);
}