package org.kie.kogito.research.application.api;

/**
 * A Container of Addressable objects,
 * which is also Addressable
 *
 */
public interface AddressableContainerFactory {
    AddressableContainer<? extends Addressable> create(Id id);
    Class<? extends AddressableContainer<? extends Addressable>> type();
}
