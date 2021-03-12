package org.kie.kogito.research.application.api;

import org.kie.kogito.research.application.api.events.ModelEvent;
import org.kie.kogito.research.application.api.ids.ModelId;
import org.kie.kogito.research.application.api.messages.ModelMessage;

public interface ModelContainer<T extends ModelId, E extends ModelMessage<T>, U extends ModelEvent<T, E>, I extends Model<T, E, U>> {
    Application application();

    I get(T unitId);

    void send(U event);
}
