package org.kie.kogito.research.application.api;

import org.reactivestreams.Publisher;

import java.util.function.Consumer;

public interface MessageBus<T extends Event> {
    public void send(T event);
    default public void subscribe(Consumer<T> consumer) {}
    default public Publisher<T> publisher() { throw new UnsupportedOperationException(); }
}
