package org.kie.kogito.research.application.api;

import org.reactivestreams.Publisher;

import java.util.function.Consumer;

public interface MessageBus<T extends Event> {
    void send(T event);
    default  void subscribe(Consumer<T> consumer) {}
    default  void unSubscribe(Consumer<T> consumer) {}
    default  Publisher<T> publisher() { throw new UnsupportedOperationException(); }
}
