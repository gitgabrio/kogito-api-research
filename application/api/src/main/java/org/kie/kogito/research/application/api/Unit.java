package org.kie.kogito.research.application.api;

public interface Unit<T extends Unit<T>> extends Addressable {
    Application application();
    UnitInstanceContainer<T, ? extends Instance<T>> instances();
}