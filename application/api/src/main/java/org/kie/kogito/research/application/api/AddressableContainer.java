package org.kie.kogito.research.application.api;

/**
 * A Container of Addressable objects,
 * which is also Addressable
 *
 */
public interface AddressableContainer<T extends Addressable> extends Addressable {
    T get(RelativeId id);
}
