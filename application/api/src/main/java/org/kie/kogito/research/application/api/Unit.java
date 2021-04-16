package org.kie.kogito.research.application.api;

public interface Unit<T extends Unit<T>> {
    Application application();
    UnitId id();
    UnitInstanceContainer<T, ? extends Instance<T>> instances();
}