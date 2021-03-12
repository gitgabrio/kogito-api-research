package org.kie.kogito.research.application.api;

import org.kie.kogito.research.application.api.events.ModelEvent;
import org.kie.kogito.research.application.api.ids.ModelId;
import org.kie.kogito.research.application.api.messages.ModelMessage;

public interface Model<T extends ModelId, E extends ModelMessage<T>, U extends ModelEvent<T, E>> {

    <I extends Model<T, E, U>, K extends ModelContainer<T, E, U, I>> Application<T, E, U, I, K> application();
    T id();
    MessageBus<T, E, U> messageBus();


}