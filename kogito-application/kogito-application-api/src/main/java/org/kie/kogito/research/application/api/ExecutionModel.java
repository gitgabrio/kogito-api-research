package org.kie.kogito.research.application.api;

import org.kie.kogito.research.application.api.events.Event;

public interface ExecutionModel {
    void onEvent(Event event);
}
