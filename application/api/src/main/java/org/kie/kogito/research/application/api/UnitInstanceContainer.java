package org.kie.kogito.research.application.api;

public interface UnitInstanceContainer<T extends Unit> {
    Instance<T> get(Id instanceId);

    Instance<T> create(Context ctx);

    Id id();
}