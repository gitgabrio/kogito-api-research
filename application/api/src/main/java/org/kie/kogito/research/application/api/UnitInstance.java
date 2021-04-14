package org.kie.kogito.research.application.api;

public interface UnitInstance {
    UnitInstanceId id();
    Unit unit();
    <T extends Context> T context(Class<T> cls);
}
