package org.kie.kogito.research.application.api;

import java.util.List;

public interface Id {
    Id parent();
    Id append(RelativeId id);
    RelativeId segment();
    List<RelativeId> segments();
}
