package org.kie.kogito.research.application.api;

public interface Id {
    Id append(RelativeId id);

    Id parent();
    RelativeId segment();
}
