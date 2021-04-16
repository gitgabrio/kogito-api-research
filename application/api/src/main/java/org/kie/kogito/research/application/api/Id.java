package org.kie.kogito.research.application.api;

public interface Id {
    Id append(RelativeId id);

    default boolean isAbsolute() {
        return true;
    }

    RelativeId segment();
}
