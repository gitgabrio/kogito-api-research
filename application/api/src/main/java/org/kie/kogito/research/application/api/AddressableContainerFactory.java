package org.kie.kogito.research.application.api;

public interface AddressableContainerFactory<I extends Addressable> extends
        AddressableContainer<I>,
        AddressableFactory<I, Context> {
}