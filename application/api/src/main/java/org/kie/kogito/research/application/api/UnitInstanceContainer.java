package org.kie.kogito.research.application.api;

public interface UnitInstanceContainer<T extends UnitInstance> {
    T get(UnitInstanceId instanceId);

    T create(Context ctx);

    T start();
}