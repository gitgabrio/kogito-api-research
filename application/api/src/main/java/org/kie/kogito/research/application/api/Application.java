package org.kie.kogito.research.application.api;

public interface Application {

    Id id();
    <T extends Unit> UnitContainer<T> get(Class<T> ctr);

}
