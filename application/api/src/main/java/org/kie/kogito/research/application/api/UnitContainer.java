package org.kie.kogito.research.application.api;

public interface UnitContainer<T extends Unit<T>> extends AddressableContainer<T> {
    Application application();
}
