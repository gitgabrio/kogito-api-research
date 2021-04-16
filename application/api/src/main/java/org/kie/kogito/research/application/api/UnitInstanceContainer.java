package org.kie.kogito.research.application.api;

public interface UnitInstanceContainer<T extends Unit, I extends Instance<T>> {
    Id id();
    I get(Id instanceId);
    I create(Context ctx);
}