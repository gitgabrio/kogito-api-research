package org.kie.kogito.research.application.api;

public interface UnitContainer<T extends Unit> {
    Application application();

    Id id();
    T get(UnitId unitId);
}
