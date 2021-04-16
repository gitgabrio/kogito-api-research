package org.kie.kogito.research.application.api;

public interface AddressableFactory<I extends Addressable, C> extends AddressableContainer<I> {
    I create(C ctx);
}
