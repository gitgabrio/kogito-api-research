package org.kie.kogito.research.application.api;

import org.kie.kogito.research.application.api.events.ModelEvent;
import org.kie.kogito.research.application.api.ids.ModelId;
import org.kie.kogito.research.application.api.messages.ModelMessage;
import org.reactivestreams.Publisher;

import java.util.function.Consumer;

public interface MessageBus<T extends ModelId, E extends ModelMessage<T>, U extends ModelEvent<T, E>> {
    void send(U event);
    default  void subscribe(Consumer<U> consumer) {}
    default  void unSubscribe(Consumer<U> consumer) {}
    default  Publisher<U> publisher() { throw new UnsupportedOperationException(); }
}
