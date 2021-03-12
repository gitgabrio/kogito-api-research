package org.kie.kogito.research.application.api;

import org.kie.kogito.research.application.api.events.ModelEvent;
import org.kie.kogito.research.application.api.ids.ModelId;
import org.kie.kogito.research.application.api.messages.ModelMessage;

public interface Application<T extends ModelId, E extends ModelMessage<T>, U extends ModelEvent<T, E>, I extends Model<T, E, U>, K extends ModelContainer<T, E, U, I>> {

    K get(Class<K> ctr);

    void send(U event);
}
