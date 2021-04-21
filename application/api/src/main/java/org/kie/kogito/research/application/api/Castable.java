package org.kie.kogito.research.application.api;

public interface Castable<U> {
    <I extends U> I as(Class<I> cls);
}
