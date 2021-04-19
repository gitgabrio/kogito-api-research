package org.kie.kogito.research.application.api;

public interface Castable {
    default <U extends Unit<U>, I extends Instance<U>> I as(Class<I> cls) {
        return cls.cast(this);
    }
}
