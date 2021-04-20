package org.kie.kogito.research.application.api;

public interface Addressable<T> {
    Id id();
    T resolve();
}
