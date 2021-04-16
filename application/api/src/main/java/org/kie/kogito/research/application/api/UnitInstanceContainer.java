package org.kie.kogito.research.application.api;

public interface UnitInstanceContainer<I extends Instance<?>> extends AddressableFactory<I, Context> {
    Id id();
    I get(RelativeId instanceId);
    I create(Context ctx);
}