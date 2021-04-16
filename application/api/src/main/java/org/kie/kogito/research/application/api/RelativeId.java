package org.kie.kogito.research.application.api;

public interface RelativeId {
    default boolean isAbsolute() {
        return false;
    }
    default RelativeId segment() {
        return this;
    }
}
