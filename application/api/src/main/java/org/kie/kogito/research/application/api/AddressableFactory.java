package org.kie.kogito.research.application.api;

/**
 * Creates an Addressable from a Context object
 */
public interface AddressableFactory<I extends Addressable, C> {
    I create(C ctx);
}
