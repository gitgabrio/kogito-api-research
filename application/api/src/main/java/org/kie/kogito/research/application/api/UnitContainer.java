package org.kie.kogito.research.application.api;

public interface UnitContainer<T extends Unit> {
    Application application();
    T get(UnitId unitId);

    Id id();
}
