package org.kie.kogito.research.application.api;

/**
 * An AddressableContainer which is also a factory of Addressables
 */
public interface AddressableContainerFactory<I extends Addressable> extends
        AddressableContainer<I>,
        AddressableFactory<I, Context> {
}