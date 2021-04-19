package org.kie.kogito.research.application.api;

public interface Castable<U> {
    default <I extends U> I as(Class<I> cls) {
        return cls.cast(this);
    }
}
